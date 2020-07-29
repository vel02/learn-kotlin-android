package kiz.learnwithvel.yelinc.ui.signedin;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.databinding.ActivitySignedInBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

public class SignedInActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    ActivitySignedInBinding binding;

    private SignedInViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, providerFactory).get(SignedInViewModel.class);

    }
}