package ar.com.wolox.android.training.di

import android.app.Application
import ar.com.wolox.android.training.TrainingCasanovaApplication
import ar.com.wolox.android.training.ui.home.HomeModule
import ar.com.wolox.android.training.ui.login.LoginModule
import ar.com.wolox.android.training.ui.root.RootModule
import ar.com.wolox.android.training.ui.signup.SignUpModule
import ar.com.wolox.wolmo.core.di.modules.ContextModule
import ar.com.wolox.wolmo.core.di.modules.DefaultModule
import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.networking.di.NetworkingComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(dependencies = [NetworkingComponent::class],
        modules = [AndroidSupportInjectionModule::class, DefaultModule::class, ContextModule::class,
            LoginModule::class, SignUpModule::class, HomeModule::class, RootModule::class])
interface AppComponent : AndroidInjector<TrainingCasanovaApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TrainingCasanovaApplication>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

        @BindsInstance
        abstract fun sharedPreferencesName(sharedPrefName: String): Builder

        abstract fun networkingComponent(networkingComponent: NetworkingComponent): Builder
    }
}
