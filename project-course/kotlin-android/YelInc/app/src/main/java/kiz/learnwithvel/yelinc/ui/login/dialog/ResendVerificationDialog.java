package kiz.learnwithvel.yelinc.ui.login.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.DialogVerificationBinding;

import static kiz.learnwithvel.yelinc.util.Utilities.Dialog.hideSoftKeyboard;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.areFieldEmpty;
import static kiz.learnwithvel.yelinc.util.Utilities.Field.isValid;
import static kiz.learnwithvel.yelinc.util.Utilities.Message.showMessage;

public class ResendVerificationDialog extends DialogFragment {

    private static final String TAG = "ResendVerification";
    DialogVerificationBinding binding;
    private Context context;


    private String email, password;

    @Override
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }

    private void configuration() {
        if (getDialog() == null) return;
        getDialog().setCanceledOnTouchOutside(false);
    }

    private void getFieldValues() {
        email = binding.dialogVerificationEmail.getText().toString();
        password = binding.dialogVerificationPassword.getText().toString();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogVerificationBinding.inflate(inflater);
        context = getActivity();
        confirm();
        cancel();
        configuration();
        return binding.getRoot();
    }

    private void confirm() {
        binding.dialogVerificationConfirm.setOnClickListener(view -> {
            getFieldValues();

            if (areFieldEmpty(email, password)) {
                if (isValid(email)) {
                    authenticateAndResendEmail(email, password);
                } else {
                    showMessage(binding.dialogVerificationParent, "Invalid email. Please use a valid domain");
                }

            } else {
                showMessage(binding.dialogVerificationParent, "You must fill out all the fields");
            }
            hideSoftKeyboard(view);
        });
    }

    private void cancel() {
        binding.dialogVerificationCancel.setOnClickListener(view -> {
            Objects.requireNonNull(getDialog()).dismiss();
        });
    }

    private void authenticateAndResendEmail(String email, String password) {
        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        sendVerificationEmail();
                        FirebaseAuth.getInstance().signOut();
                        Objects.requireNonNull(getDialog()).dismiss();
                    }
                }).addOnFailureListener(e -> {
            showMessage(binding.dialogVerificationParent, "Invalid Credential. Reset your password and try again");
        });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener((Activity) context, task -> {
                        if (task.isSuccessful()) {
                            showMessage(context, "Sent verification email");
                        } else {
                            showMessage(context, "Could'nt send verification email");
                        }
                    });
        }
    }


}
