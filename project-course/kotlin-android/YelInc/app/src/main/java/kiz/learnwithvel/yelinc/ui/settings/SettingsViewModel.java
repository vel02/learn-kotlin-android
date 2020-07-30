package kiz.learnwithvel.yelinc.ui.settings;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    @Inject
    public SettingsViewModel() {
        showLoading.setValue(false);
    }

    public void setShowLoading(boolean showLoading) {
        this.showLoading.setValue(showLoading);
    }

    public LiveData<Boolean> observeLoading() {
        return showLoading;
    }


    public void sendResetPassword(View view) {
        showLoading.setValue(true);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null && user.getEmail() != null) {
            FirebaseAuth.getInstance().sendPasswordResetEmail(user.getEmail()).
                    addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            showMessage(view, "Password Reset Email Sent");
                        } else {
                            showMessage(view, "No user associated with that email");
                        }
                        showLoading.setValue(false);
                    });
        }
    }

    public AuthCredential signInCredential(String password) {
        showLoading.setValue(true);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            if (user.getEmail() != null) {
                return EmailAuthProvider.getCredential(user.getEmail(), password);
            }
        }
        return null;
    }

    public void applyEmail(View view, String email) {

        FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        if (task.getResult().getSignInMethods().size() == 1) {
                            showMessage(view, "Email is already in use");
                            showLoading.setValue(false);
                        } else {
                            updateEmail(view, email);
                        }

                    }
                }).addOnFailureListener(e -> {
            showLoading.setValue(false);
            showMessage(view, "Unable to update email");
        });
    }

    private void updateEmail(View view, String email) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.updateEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            showMessage(view, "Email address updated");
                            sendVerificationEmail(view);
                            FirebaseAuth.getInstance().signOut();
                        } else {
                            showMessage(view, "Could'nt update email");
                        }
                        showLoading.setValue(false);
                    }).addOnFailureListener(e -> {
                showLoading.setValue(false);
                showMessage(view, "Unable to update email");
            });
        }
    }

    private void sendVerificationEmail(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            showMessage(view, "Sent Verification Email");
                        } else {
                            showMessage(view, "Could'nt send verification to your email");
                        }
                    });
        }

    }


}
