package br.com.igorbag.githubapp.presentation.features.di

import android.os.Bundle
import br.com.igorbag.githubapp.presentation.features.detail.DetailViewModel
import br.com.igorbag.githubapp.presentation.features.users.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object FeaturesModule {
    fun load() {
        loadKoinModules(module {
            viewModelOf(::UserViewModel)
            viewModel { (args: Bundle) ->
                DetailViewModel(args, get(), get())
            }
        })
    }
}