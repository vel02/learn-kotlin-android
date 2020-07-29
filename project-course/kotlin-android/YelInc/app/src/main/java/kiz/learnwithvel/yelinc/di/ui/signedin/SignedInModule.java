package kiz.learnwithvel.yelinc.di.ui.signedin;

import androidx.databinding.DataBindingUtil;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import kiz.learnwithvel.yelinc.databinding.ActivitySignedInBinding;
import kiz.learnwithvel.yelinc.ui.signedin.SignedInActivity;

@Module
public class SignedInModule {


    @Provides
    static ActivitySignedInBinding provideActivitySignedInBinding(SignedInActivity activity, @Named("Signed In Activity") int layout) {
        return DataBindingUtil.setContentView(activity, layout);
    }

}
