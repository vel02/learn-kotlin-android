package kiz.learnwithvel.yelinc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.ActivityLoginBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

import static kiz.learnwithvel.yelinc.util.Utilities.Field.areFieldEmpty;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    ActivityLoginBinding binding;

    private LoginViewModel viewModel;

    private String email, password;

    private void getFieldValues() {
        email = binding.contentLogin.loginEmail.getText().toString();
        password = binding.contentLogin.loginPassword.getText().toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(viewModel.getAuthStateListener());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel.getAuthStateListener() != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(viewModel.getAuthStateListener());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activateToolbar(false, "Login");
        viewModel = new ViewModelProvider(this, providerFactory).get(LoginViewModel.class);
        viewModel.firebaseAuthListener();
        binding.contentLogin.setListener(this);
        login();
        subscribeObserver();
    }

    private void login() {

        binding.contentLogin.loginLogin.setOnClickListener(view -> {
            getFieldValues();
            if (areFieldEmpty(email, password)) {
                if (isValid(email)) {
                    viewModel.signInAccount(email, password);
                } else {
                    showMessage(binding.loginParent, "Invalid email. Please use a valid domain");
                }
            } else {
                showMessage(binding.loginParent, "You must fill out all the fields");
            }
        });

    }

    private void subscribeObserver() {

        viewModel.observeLoading().observe(this, showLoading -> {
            if (showLoading != null) {
                binding.setShowLoading(showLoading);
            }
        });

        viewModel.observeAuthStatus().observe(this, authResource -> {
            if (authResource != null) {
                showMessage(binding.loginParent, authResource.message);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_register: {
                Intent intent = new Intent(this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        }
    }
}