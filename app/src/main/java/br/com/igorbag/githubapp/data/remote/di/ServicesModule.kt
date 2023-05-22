package br.com.igorbag.githubapp.data.remote.di

import br.com.igorbag.githubapp.data.remote.service.GithubService
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

object ServicesModule {
    fun load() {
        loadKoinModules(module {
            factory { get<Retrofit>().create<GithubService>() }
        })
    }
}
