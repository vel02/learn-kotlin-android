package kiz.learnwithvel.yelinc.ui.register;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    @Inject
    public RegisterViewModel() {
        showLoading.setValue(false);
    }

    public LiveData<Boolean> observeLoading() {
        return showLoading;
    }

    public void registerNewEmail(RegisterActivity activity, View view, String email, String password) {
        showLoading.setValue(true);
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        showMessage(view, "Account is successfully created");
                        showLoading.setValue(false);
                        FirebaseAuth.getInstance().signOut();
                    } else {
                        showMessage(view, "Unable to register. Try use different Email");
                        showLoading.setValue(false);
                    }
                });
    }

}
