package kiz.learnwithvel.yelinc.di.ui.settings;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kiz.learnwithvel.yelinc.di.ViewModelKey;
import kiz.learnwithvel.yelinc.ui.settings.SettingsViewModel;

@Module
public abstract class SettingsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel.class)
    abstract ViewModel bindSettingsViewModel(SettingsViewModel viewModel);


}
