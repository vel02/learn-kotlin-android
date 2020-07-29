package kiz.learnwithvel.yelinc.ui.signedin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.resource.AuthResource;

public class SignedInViewModel extends ViewModel {

    private static final String TAG = "SignedInViewModel";

    private MutableLiveData<AuthResource> authState = new MutableLiveData<>();
    private FirebaseAuth.AuthStateListener authStateListener;

    @Inject
    public SignedInViewModel() {
        setupAuthStateListener();
    }

    public LiveData<AuthResource> observeAuthState() {
        return authState;
    }

    public FirebaseAuth.AuthStateListener getAuthStateListener() {
        return authStateListener;
    }

    private void setupAuthStateListener() {
        authStateListener = firebaseAuth -> {

            FirebaseUser user = firebaseAuth.getCurrentUser();

            if (user == null) {
                authState.setValue(AuthResource.unauthenticated("Unauthenticated"));
            } else {
                authState.setValue(AuthResource.authenticated(user.getEmail()));
            }

        };
    }

    public void addAuthStateListener() {
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
    }

    public void removeAuthStateListener() {
        if (authStateListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);
        }
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }

}
