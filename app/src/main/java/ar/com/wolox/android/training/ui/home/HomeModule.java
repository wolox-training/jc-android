package ar.com.wolox.android.training.ui.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

    @ContributesAndroidInjector
    public abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    public abstract HomeFragment homeFragment();
}
