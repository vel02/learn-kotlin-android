package kiz.learnwithvel.yelinc.ui.login.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.DialogForgotPasswordBinding;

public class ForgotPasswordDialog extends DialogFragment {

    DialogForgotPasswordBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogForgotPasswordBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }

}
