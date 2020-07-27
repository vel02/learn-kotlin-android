package kiz.learnwithvel.yelinc.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import kiz.learnwithvel.yelinc.viewmodel.ViewModelProviderFactory;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelProviderFactory(ViewModelProviderFactory providerFactory);

}
