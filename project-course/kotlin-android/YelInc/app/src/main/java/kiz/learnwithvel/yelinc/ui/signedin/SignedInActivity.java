package kiz.learnwithvel.yelinc.ui.signedin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.databinding.ActivitySignedInBinding;
import kiz.learnwithvel.yelinc.ui.BaseActivity;
import kiz.learnwithvel.yelinc.ui.login.LoginActivity;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

public class SignedInActivity extends BaseActivity {

    private static final String TAG = "SignedInActivity";

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    ActivitySignedInBinding binding;

    private SignedInViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activateToolbar(false, "Straw Hat Crew");
        viewModel = new ViewModelProvider(this, providerFactory).get(SignedInViewModel.class);
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.observeAuthState().observe(this, authResource -> {
            if (authResource != null) {
                switch (authResource.status) {
                    case AUTHENTICATED:
                        Log.d(TAG, "subscribeObservers: AUTHENTICATED WITH: " + authResource.message);
                        break;
                    case UNAUTHENTICATED:
                        Log.d(TAG, "subscribeObservers: STATE: " + authResource.message);
                        Intent intent = new Intent(SignedInActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });

        viewModel.observeUserState().observe(this, user -> {
            if (user != null) {
                if (!user.getName().isEmpty()) {
                    binding.contentSignedIn.setName(user.getEmail());
                } else {
                    binding.contentSignedIn.setName("Pirate Crew");
                }
                binding.contentSignedIn.setSource(user.getPhoto());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signed_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            viewModel.signOut();
            return true;
        } else if (item.getItemId() == R.id.action_update_profile) {
            Log.d(TAG, "onOptionsItemSelected: update profile here...");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.addAuthStateListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (viewModel.getAuthStateListener() != null) {
            viewModel.removeAuthStateListener();
        }
    }

}