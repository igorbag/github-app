package br.com.igorbag.githubapp.data.data.di

import br.com.igorbag.githubapp.data.data.repository.GitHubRepositoryImpl
import br.com.igorbag.githubapp.domain.repository.GithubReporitory
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataModule {
    fun load() {
        loadKoinModules(module {
            factory<GithubReporitory> { GitHubRepositoryImpl(get()) }
        })
    }
}
