package com.tabac.egovernment.di

import com.tabac.egovernment.screens.main.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}