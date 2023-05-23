package br.com.igorbag.githubapp

import android.app.Application
import br.com.igorbag.githubapp.data.data.di.DataModule
import br.com.igorbag.githubapp.data.remote.di.NetworkModule
import br.com.igorbag.githubapp.data.remote.di.RemoteModule
import br.com.igorbag.githubapp.data.remote.di.ServicesModule
import br.com.igorbag.githubapp.domain.di.DomainModule
import br.com.igorbag.githubapp.presentation.features.di.FeaturesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
        }

        loadAllModules()
    }

    private fun loadAllModules() {
        DataModule.load()
        DomainModule.load()
        RemoteModule.load()
        NetworkModule.load()
        ServicesModule.load()
        FeaturesModule.load()
    }
}
