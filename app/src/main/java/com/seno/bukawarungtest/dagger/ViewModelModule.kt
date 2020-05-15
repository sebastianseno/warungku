package com.seno.bukawarungtest.dagger

import androidx.lifecycle.ViewModelProvider
import com.seno.bukawarungtest.dagger.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}