package ar.com.wolox.android.training.ui.root;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RootModule {

    @ContributesAndroidInjector
    public abstract RootActivity rootActivity();

    @ContributesAndroidInjector
    public abstract RootFragment rootFragment();
}
