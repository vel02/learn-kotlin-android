package kiz.learnwithvel.yelinc.ui.signedin.dialog;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.DialogUpdateProfileBinding;

import static kiz.learnwithvel.yelinc.util.Utilities.Dialog.hideSoftKeyboard;

public class UpdateProfileDialog extends DialogFragment {

    private static final String TAG = "UpdateProfile";

    DialogUpdateProfileBinding binding;

    private OnDialogListener listener;
    private String name, photo;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        if (!(activity instanceof OnDialogListener)) {
            throw new ClassCastException(activity.getClass().getSimpleName() +
                    "must implement OnDialogListener");
        }
        listener = (OnDialogListener) activity;
    }

    private void configuration() {
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(false);
        }
    }

    private void getFieldValues() {
        name = binding.dialogUpdateProfileName.getText().toString();
        photo = binding.dialogUpdateProfilePhoto.getText().toString();
    }

    @Override
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogUpdateProfileBinding.inflate(inflater);
        configuration();
        cancel();
        confirm();
        return binding.getRoot();
    }

    private void cancel() {
        binding.dialogUpdateProfileCancel.setOnClickListener(view -> {
            if (getDialog() != null)
                getDialog().dismiss();
        });
    }

    private void confirm() {
        binding.dialogUpdateProfileConfirm.setOnClickListener(view -> {
            getFieldValues();
            setUserDetails();
            hideSoftKeyboard(view);
        });
    }

    private void setUserDetails() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest request = new UserProfileChangeRequest
                    .Builder()
                    .setDisplayName((!name.isEmpty()) ? name : user.getDisplayName())
                    .setPhotoUri((!photo.isEmpty()) ? Uri.parse(photo) : user.getPhotoUrl())
                    .build();

            user.updateProfile(request).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Objects.requireNonNull(getDialog()).dismiss();
                    listener.updateUserProfile();
                }
            });
        }
    }

    public interface OnDialogListener {
        void updateUserProfile();
    }

}
