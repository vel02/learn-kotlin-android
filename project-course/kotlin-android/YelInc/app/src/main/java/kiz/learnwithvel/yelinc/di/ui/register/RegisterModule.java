package kiz.learnwithvel.yelinc.di.ui.register;

import androidx.databinding.DataBindingUtil;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import kiz.learnwithvel.yelinc.databinding.ActivityRegisterBinding;
import kiz.learnwithvel.yelinc.ui.register.RegisterActivity;

@Module
public class RegisterModule {

    @Provides
    static ActivityRegisterBinding provideActivityRegisterBinding(RegisterActivity activity, @Named("Register Activity") int layout) {
        return DataBindingUtil.setContentView(activity, layout);
    }

}
