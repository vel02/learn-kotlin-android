package kiz.learnwithvel.yelinc.ui.settings;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.databinding.ActivitySettingsBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

import static kiz.learnwithvel.yelinc.util.Utilities.Activity.hideSoftKeyboard;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class SettingsActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    ActivitySettingsBinding binding;

    private SettingsViewModel viewModel;

    private String email, password;

    private void getFieldValues() {
        email = binding.contentSettings.settingsEmail.getText().toString();
        password = binding.contentSettings.settingsPassword.getText().toString();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activateToolbar(true, "Settings");
        viewModel = new ViewModelProvider(this, providerFactory).get(SettingsViewModel.class);
        editUserEmail();
        changePassword();
        subscribeObserver();
    }


    private void subscribeObserver() {
        viewModel.observeLoading().observe(this, showLoading -> {
            if (showLoading != null) {
                binding.setShowLoading(showLoading);
            }
        });
    }

    private void changePassword() {
        binding.contentSettings.settingsChangePassword.setOnClickListener(view -> {
            viewModel.sendResetPassword(view);
        });
    }

    private void editUserEmail() {
        binding.contentSettings.settingsApply.setOnClickListener(view -> {
            getFieldValues();

            AuthCredential credential = viewModel.signInCredential(password);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            if (user != null) {
                user.reauthenticate(credential)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                //re-authentication success
                                if (isValid(email)) {
                                    viewModel.applyEmail(binding.settingsParent, email);
                                } else {
                                    showMessage(binding.settingsParent, "Invalid email. Please use a valid domain");
                                    viewModel.setShowLoading(false);
                                }

                            } else {
                                showMessage(binding.settingsParent, "Incorrect Password");
                                viewModel.setShowLoading(false);
                            }
                        }).addOnFailureListener(e -> {
                    viewModel.setShowLoading(false);
                    showMessage(binding.settingsParent, "Unable to update email");
                });
            }

            hideSoftKeyboard(this);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkAuthenticationState();
    }
}