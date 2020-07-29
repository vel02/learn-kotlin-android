package kiz.learnwithvel.yelinc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.ActivityLoginBinding;
import kiz.learnwithvel.yelinc.ui.login.dialog.ForgotPasswordDialog;
import kiz.learnwithvel.yelinc.ui.login.dialog.ResendVerificationDialog;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;
import kiz.learnwithvel.yelinc.ui.signedin.SignedInActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

import static kiz.learnwithvel.yelinc.util.Utilities.Activity.hideSoftKeyboard;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.areFieldEmpty;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class LoginActivity extends DaggerAppCompatActivity implements View.OnClickListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activateToolbar();
        viewModel = new ViewModelProvider(this, providerFactory).get(LoginViewModel.class);
        binding.contentLogin.setListener(this);
        login();
        subscribeObserver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.checkAuthenticationState();
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
            hideSoftKeyboard(this);
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
                switch (authResource.status) {
                    case AUTHENTICATED:
                        showMessage(this, authResource.message);
                        Intent intent = new Intent(this, SignedInActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        finish();
                        break;
                    case VERIFICATION:
                    case UNAUTHENTICATED:
                        showMessage(this, authResource.message);
                        break;
                }
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
                break;
            }
            case R.id.login_forgot_password: {
                ForgotPasswordDialog dialog = new ForgotPasswordDialog();
                dialog.show(getSupportFragmentManager(), getString(R.string.tag_dialog_forgot_password));
                break;
            }
            case R.id.login_verification_email: {
                ResendVerificationDialog dialog = new ResendVerificationDialog();
                dialog.show(getSupportFragmentManager(), getString(R.string.tag_dialog_verification));
                break;
            }
        }
    }

    protected void activateToolbar() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(false);
                actionBar.setTitle("Login");
            }
        }
    }

}