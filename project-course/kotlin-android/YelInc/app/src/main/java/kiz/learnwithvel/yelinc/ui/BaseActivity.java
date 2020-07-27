package kiz.learnwithvel.yelinc.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import dagger.android.support.DaggerAppCompatActivity;
import kiz.learnwithvel.yelinc.R;

public class BaseActivity extends DaggerAppCompatActivity {

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
