package kiz.learnwithvel.yelinc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract RegisterActivity contributeRegisterActivity();
}
