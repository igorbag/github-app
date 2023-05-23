package br.com.igorbag.githubapp.presentation.features.di

import br.com.igorbag.githubapp.presentation.features.users.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object FeaturesModule {
    fun load() {
        loadKoinModules(module {
            viewModel { UserViewModel(get()) }
        })
    }
}