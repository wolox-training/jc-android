package ar.com.wolox.android.training.ui.signup;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SignUpModule {

    @ContributesAndroidInjector
    public abstract SignUpActivity signUpActivity();

    @ContributesAndroidInjector
    public abstract SignUpFragment signUpFragment();
}
