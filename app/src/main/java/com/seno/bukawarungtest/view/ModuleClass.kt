package com.seno.bukawarungtest.view

import androidx.lifecycle.ViewModel
import com.seno.bukawarungtest.dagger.FragmentScope
import com.seno.bukawarungtest.dagger.ViewModelKey
import com.seno.bukawarungtest.viewmodel.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ModuleClass {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindViewModel(userViewModel: UserViewModel): ViewModel
}

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector(modules = [ModuleClass::class])
    @FragmentScope
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [ModuleClass::class])
    @FragmentScope
    abstract fun userFragment(): UserFragment

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun profileFragment(): ProfileFragment
}