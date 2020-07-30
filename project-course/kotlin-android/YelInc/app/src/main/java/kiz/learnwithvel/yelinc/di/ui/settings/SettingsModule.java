package kiz.learnwithvel.yelinc.di.ui.settings;

import androidx.databinding.DataBindingUtil;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import kiz.learnwithvel.yelinc.databinding.ActivitySettingsBinding;
import kiz.learnwithvel.yelinc.ui.settings.SettingsActivity;

@Module
public class SettingsModule {

    @Provides
    static ActivitySettingsBinding provideActivitySettingBinding(SettingsActivity activity, @Named("Settings Activity") int layout) {
        return DataBindingUtil.setContentView(activity, layout);
    }

}
