package kiz.learnwithvel.yelinc.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> isAuthenticated = new MutableLiveData<>();

    private FirebaseAuth.AuthStateListener authStateListener;

    @Inject
    public LoginViewModel() {
        showLoading.setValue(false);
        isAuthenticated.setValue(null);
    }

    public FirebaseAuth.AuthStateListener getAuthStateListener() {
        return authStateListener;
    }

    public void setShowLoading(boolean show) {
        this.showLoading.setValue(show);
    }

    public LiveData<Boolean> observeLoading() {
        return showLoading;
    }

    public LiveData<Boolean> observeIsAuthenticated() {
        return isAuthenticated;
    }

    public void signInAccount(String email, String password) {
        showLoading.setValue(true);
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    showLoading.setValue(false);
                }).addOnFailureListener(e -> {
            showLoading.setValue(false);
        });
    }

    public void firebaseAuthListener() {
        authStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {

                if (user.isEmailVerified()) {
                    positiveProperties();
                } else {
                    negativeProperties();
                }
                FirebaseAuth.getInstance().signOut();
            }
        };
        isAuthenticated.setValue(null);
    }

    private void positiveProperties() {
        isAuthenticated.setValue(true);
        showLoading.setValue(false);
    }

    private void negativeProperties() {
        isAuthenticated.setValue(false);
        showLoading.setValue(false);
    }

}
