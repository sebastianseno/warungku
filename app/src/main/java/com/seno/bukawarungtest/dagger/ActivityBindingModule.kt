package com.seno.bukawarungtest.dagger

import com.seno.bukawarungtest.view.MainActivity
import com.seno.bukawarungtest.view.MainFragmentModule
import com.seno.bukawarungtest.view.ModuleClass
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            MainFragmentModule::class,
            ModuleClass::class
        ]
    )
    @ActivityScope
    abstract fun mainActivity(): MainActivity
}