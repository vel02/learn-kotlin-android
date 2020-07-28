package kiz.learnwithvel.yelinc.di.ui.login;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kiz.learnwithvel.yelinc.di.ViewModelKey;
import kiz.learnwithvel.yelinc.ui.login.LoginViewModel;

@Module
public abstract class LoginViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);

}
