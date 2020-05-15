package com.seno.bukawarungtest.dagger

import android.content.Context
import com.seno.bukawarungtest.BukaWarungTestApp
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule {
    @Binds
    abstract fun bindContext(bukaWarungTest: BukaWarungTestApp): Context
}