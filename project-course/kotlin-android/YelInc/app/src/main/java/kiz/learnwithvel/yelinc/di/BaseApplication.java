package kiz.learnwithvel.yelinc.di;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import kiz.learnwithvel.yelinc.R;

public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .registerActivity(R.layout.activity_register)
                .loginActivity(R.layout.activity_login)
                .signedInActivity(R.layout.activity_signed_in)
                .build();
    }
}
