package br.com.igorbag.githubapp.domain.di

import br.com.igorbag.githubapp.domain.usecase.GetAllUsersUseCase
import br.com.igorbag.githubapp.domain.usecase.GetUserByNameUseCase
import br.com.igorbag.githubapp.domain.usecase.GetUserRepositoryByNameUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(module {
            factory { GetAllUsersUseCase(get()) }
            factory { GetUserByNameUseCase(get()) }
            factory { GetUserRepositoryByNameUseCase(get()) }
        })
    }
}
