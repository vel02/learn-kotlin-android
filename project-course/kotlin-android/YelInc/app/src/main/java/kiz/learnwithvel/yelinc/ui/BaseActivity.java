package kiz.learnwithvel.yelinc.ui;

import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dagger.android.support.DaggerAppCompatActivity;
import kiz.learnwithvel.yelinc.R;
import kiz.learnwithvel.yelinc.ui.login.LoginActivity;

public class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    protected void checkAuthenticationState() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Log.d(TAG, "checkAuthenticationState: authenticated");
        } else {
            Log.d(TAG, "checkAuthenticationState: unauthenticated");
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        }
    }

    protected void activateToolbar(boolean enableHome, String title) {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(enableHome);
                actionBar.setTitle(title);
            }
        }
    }

}
