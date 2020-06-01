package ar.com.wolox.android.training.ui.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {

    @ContributesAndroidInjector
    public abstract LoginActivity loginActivity();

    @ContributesAndroidInjector
    public abstract LoginFragment loginFragment();
}
