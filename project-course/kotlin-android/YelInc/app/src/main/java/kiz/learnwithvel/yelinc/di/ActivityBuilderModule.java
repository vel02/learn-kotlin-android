package kiz.learnwithvel.yelinc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kiz.learnwithvel.yelinc.di.ui.login.LoginModule;
import kiz.learnwithvel.yelinc.di.ui.login.LoginViewModelModule;
import kiz.learnwithvel.yelinc.di.ui.register.RegisterModule;
import kiz.learnwithvel.yelinc.di.ui.register.RegisterViewModelModule;
import kiz.learnwithvel.yelinc.ui.login.LoginActivity;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
            modules = {
                    RegisterModule.class,
                    RegisterViewModelModule.class
            }
    )
    abstract RegisterActivity contributeRegisterActivity();

    @ContributesAndroidInjector(
            modules = {
                    LoginModule.class,
                    LoginViewModelModule.class
            }
    )
    abstract LoginActivity contributeLoginActivity();
}
