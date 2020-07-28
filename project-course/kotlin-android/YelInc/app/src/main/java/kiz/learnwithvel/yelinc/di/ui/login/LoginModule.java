package kiz.learnwithvel.yelinc.di.ui.login;

import androidx.databinding.DataBindingUtil;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import kiz.learnwithvel.yelinc.databinding.ActivityLoginBinding;
import kiz.learnwithvel.yelinc.ui.login.LoginActivity;

@Module
public class LoginModule {

    @Provides
    static ActivityLoginBinding provideActivityLoginBinding(LoginActivity activity, @Named("Login Activity") int layout) {
        return DataBindingUtil.setContentView(activity, layout);
    }

}
