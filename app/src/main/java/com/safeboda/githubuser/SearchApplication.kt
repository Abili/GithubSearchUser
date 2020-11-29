package com.safeboda.githubuser

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.safeboda.githubuser.di.appModule
import com.safeboda.githubuser.di.dbModule
import com.safeboda.githubuser.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SearchApplication)
            modules(
                listOf(
                    dbModule,
                    networkModule,
                    appModule
                )
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

    }
}