package kiz.learnwithvel.yelinc.ui.signedin;

import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.model.User;
import kiz.learnwithvel.yelinc.resource.AuthResource;

public class SignedInViewModel extends ViewModel {

    private static final String TAG = "SignedInViewModel";

    private MutableLiveData<AuthResource> authState = new MutableLiveData<>();
    private MutableLiveData<User> userState = new MutableLiveData<>();
    private FirebaseAuth.AuthStateListener authStateListener;

    @Inject
    public SignedInViewModel() {
        setupAuthStateListener();
    }

    public LiveData<AuthResource> observeAuthState() {
        return authState;
    }

    public LiveData<User> observeUserState() {
        return userState;
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

                String uid = user.getUid();
                String name = user.getDisplayName();
                String email = user.getEmail();
                Uri photo = user.getPhotoUrl();

                String properties = "\nuid: " + uid + "\n"
                        + "name: " + name + "\n"
                        + "email: " + email + "\n"
                        + "photo: " + photo;

                Log.d(TAG, "getUserDetails: properties: " + properties);

                User u = new User(uid, name, email, photo);
                userState.setValue(u);
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
