package kiz.learnwithvel.yelinc.di.ui.signedin;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kiz.learnwithvel.yelinc.di.ViewModelKey;
import kiz.learnwithvel.yelinc.ui.signedin.SignedInViewModel;

@Module
public abstract class SignedInViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignedInViewModel.class)
    abstract ViewModel bindSignedInViewModel(SignedInViewModel viewModel);

}
