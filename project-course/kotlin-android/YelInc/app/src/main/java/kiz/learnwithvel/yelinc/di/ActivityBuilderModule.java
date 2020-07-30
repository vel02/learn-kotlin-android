package kiz.learnwithvel.yelinc.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kiz.learnwithvel.yelinc.di.ui.login.LoginModule;
import kiz.learnwithvel.yelinc.di.ui.login.LoginViewModelModule;
import kiz.learnwithvel.yelinc.di.ui.register.RegisterModule;
import kiz.learnwithvel.yelinc.di.ui.register.RegisterViewModelModule;
import kiz.learnwithvel.yelinc.di.ui.settings.SettingsModule;
import kiz.learnwithvel.yelinc.di.ui.settings.SettingsViewModelModule;
import kiz.learnwithvel.yelinc.di.ui.signedin.SignedInModule;
import kiz.learnwithvel.yelinc.di.ui.signedin.SignedInViewModelModule;
import kiz.learnwithvel.yelinc.ui.login.LoginActivity;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;
import kiz.learnwithvel.yelinc.ui.settings.SettingsActivity;
import kiz.learnwithvel.yelinc.ui.signedin.SignedInActivity;

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

    @ContributesAndroidInjector(
            modules = {
                    SignedInModule.class,
                    SignedInViewModelModule.class
            }
    )
    abstract SignedInActivity contributeSignedInActivity();

    @ContributesAndroidInjector(
            modules = {
                    SettingsModule.class,
                    SettingsViewModelModule.class
            }
    )
    abstract SettingsActivity contributeSettingActivity();


}
