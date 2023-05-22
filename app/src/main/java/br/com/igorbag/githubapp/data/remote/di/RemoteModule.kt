package br.com.igorbag.githubapp.data.remote.di

import br.com.igorbag.githubapp.data.data.source.GithubDataSource
import br.com.igorbag.githubapp.data.remote.repository.GithubDataSourceRemote
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RemoteModule {
    fun load() {
        loadKoinModules(module {
            factory<GithubDataSource.Remote> { GithubDataSourceRemote(get()) }
        })
    }
}
