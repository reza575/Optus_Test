package com.moeiny.reza.optus_test

import android.app.Application
import com.moeiny.reza.optus_test.core.di.ApplicationComponent
import com.moeiny.reza.optus_test.core.di.ApplicationModule
import com.moeiny.reza.optus_test.core.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val component : ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}