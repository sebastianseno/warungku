package com.seno.bukawarungtest.dagger

import com.seno.bukawarungtest.BukaWarungTestApp
import com.seno.bukawarungtest.db.DataBaseModule
import com.seno.bukawarungtest.rest.RetrofitModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ContextModule::class,
        DataBaseModule::class,
        ActivityBindingModule::class,
        RetrofitModule::class
    ]
)

interface AppComponent : AndroidInjector<BukaWarungTestApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<BukaWarungTestApp>
}