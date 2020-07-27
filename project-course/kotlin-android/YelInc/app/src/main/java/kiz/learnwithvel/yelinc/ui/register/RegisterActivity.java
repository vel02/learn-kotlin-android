package kiz.learnwithvel.yelinc.ui.register;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.ActivityRegisterBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

import static kiz.learnwithvel.yelinc.util.Utilities.Field.areFieldEmpty;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isMatch;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class RegisterActivity extends BaseActivity {

    private static final String TAG = "RegisterActivity";

    @Inject
    ViewModelProviderFactory providerFactory;

    ActivityRegisterBinding binding;
    RegisterViewModel viewModel;

    private String email, password, confirm;

    private void getFieldValues() {
        email = binding.contentRegister.registerEmail.getText().toString();
        password = binding.contentRegister.registerPassword.getText().toString();
        confirm = binding.contentRegister.registerConfirmPassword.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, providerFactory).get(RegisterViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        activateToolbar(false, "Register");
        register();
    }

    private void register() {
        binding.contentRegister.registerRegister.setOnClickListener(view -> {
            getFieldValues();
            if (areFieldEmpty(email, password, confirm)) {
                if (isValid(email)) {
                    if (isMatch(password, confirm)) {
                        binding.setShowLoading(true);
                        showMessage(binding.registerParent, "User authentication success");
                    } else {
                        showMessage(binding.registerParent, "Invalid password. It does not match");
                    }
                } else {
                    showMessage(binding.registerParent, "Invalid email. Please use a valid domain");
                }
            } else {
                showMessage(binding.registerParent, "You must fill out all the fields");
            }
        });
    }


}