package kiz.learnwithvel.yelinc.ui.login;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.resource.AuthResource;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<AuthResource> authStatus = new MutableLiveData<>();

    @Inject
    public LoginViewModel() {
        showLoading.setValue(false);
        authStatus.setValue(null);
    }

    public void setShowLoading(boolean show) {
        this.showLoading.setValue(show);
    }

    public LiveData<Boolean> observeLoading() {
        return showLoading;
    }

    public LiveData<AuthResource> observeAuthStatus() {
        return authStatus;
    }

    public void signInAccount(String email, String password) {
        showLoading.setValue(true);
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    showLoading.setValue(false);
                    if (task.isSuccessful()) {
                        verifyAuthentication();
                    }
                }).addOnFailureListener(e -> {
            authStatus.setValue(AuthResource.unauthenticated("Authentication Failed. Make sure to have a correct email or password"));
            showLoading.setValue(false);
        });
    }

    private void verifyAuthentication() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            if (user.isEmailVerified()) {
                authStatus.setValue(AuthResource.authenticated("Authentication Success"));
                showLoading.setValue(false);
            } else {
                authStatus.setValue(AuthResource.verification("Check your Email Inbox for a Verification Link"));
                showLoading.setValue(false);
                FirebaseAuth.getInstance().signOut();
            }
        }
    }

    public void checkAuthenticationState() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            authStatus.setValue(AuthResource.authenticated("Authenticated"));
            Log.d(TAG, "checkAuthenticationState: authenticated");
        } else {
            authStatus.setValue(AuthResource.unauthenticated("Unauthenticated"));
            Log.d(TAG, "checkAuthenticationState: unauthenticated");
        }
    }

}
