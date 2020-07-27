package kiz.learnwithvel.yelinc.di.ui.register;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kiz.learnwithvel.yelinc.di.ViewModelKey;
import kiz.learnwithvel.yelinc.ui.register.RegisterViewModel;

@Module
public abstract class RegisterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    abstract ViewModel bindRegisterViewModel(RegisterViewModel viewModel);

}
