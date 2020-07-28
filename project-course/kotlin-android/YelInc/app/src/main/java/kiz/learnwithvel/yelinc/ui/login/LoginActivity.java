package kiz.learnwithvel.yelinc.ui.login;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.databinding.ActivityLoginBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

public class LoginActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    ActivityLoginBinding binding;

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, providerFactory).get(LoginViewModel.class);
        activateToolbar(false, "Login");
    }
}