package com.project.rxc.init

import android.content.Context
import androidx.startup.Initializer
import com.project.rxc.BuildConfig
import timber.log.Timber

class TimberInitializer:Initializer<Unit> {
    override fun create(context: Context) {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
            Timber.d("initialize timber")
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}