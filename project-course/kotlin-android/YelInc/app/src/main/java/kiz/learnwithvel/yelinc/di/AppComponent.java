package kiz.learnwithvel.yelinc.di;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuilderModule.class,
                ViewModelFactoryModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder registerActivity(@Named("Register Activity") int layout);

        @BindsInstance
        Builder loginActivity(@Named("Login Activity") int layout);

        @BindsInstance
        Builder signedInActivity(@Named("Signed In Activity") int layout);

        AppComponent build();
    }

}
