package com.seno.bukawarungtest

import com.seno.bukawarungtest.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class BukaWarungTestApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}