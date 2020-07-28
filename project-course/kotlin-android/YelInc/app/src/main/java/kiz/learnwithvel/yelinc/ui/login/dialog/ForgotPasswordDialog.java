package kiz.learnwithvel.yelinc.ui.login.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.DialogForgotPasswordBinding;

import static kiz.learnwithvel.yelinc.util.Utilities.Dialog.hideSoftKeyboard;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isFieldEmpty;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class ForgotPasswordDialog extends DialogFragment {

    DialogForgotPasswordBinding binding;

    private String email;

    @Override
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }

    private void getFieldValue() {
        email = binding.dialogForgotPassEmail.getText().toString();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogForgotPasswordBinding.inflate(inflater);
        confirm();
        return binding.getRoot();
    }

    private void confirm() {
        binding.dialogForgotPassConfirm.setOnClickListener(view -> {
            getFieldValue();
            if (isFieldEmpty(email)) {
                if (isValid(email)) {
                    resetPassword(email);
                } else {
                    showMessage(binding.dialogForgotPassParent, "Invalid email. Please use a valid domain");
                }
            } else {
                showMessage(binding.dialogForgotPassParent, "You must fill out the field");
            }
            hideSoftKeyboard(view);
        });
    }

    private void resetPassword(String email) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        showMessage(getActivity(), "Password Reset Link Sent to Email");
                        Objects.requireNonNull(getDialog()).dismiss();
                    } else {
                        showMessage(binding.dialogForgotPassParent, "No User is Associated with that Email");
                    }
                });
    }

}
