package br.com.igorbag.githubapp.presentation.features.detail

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.usecase.GetUserByNameUseCase
import br.com.igorbag.githubapp.domain.usecase.GetUserRepositoryByNameUseCase
import br.com.igorbag.githubapp.presentation.core.BaseViewModel
import br.com.igorbag.githubapp.presentation.core.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    args: Bundle,
    private val getUserByNameUseCase: GetUserByNameUseCase,
    private val getUserRepositoryByName: GetUserRepositoryByNameUseCase,
) : BaseViewModel<DetailState, DetailAction>(DetailState()) {

    private val userName: String = checkNotNull(args.getString(USER_NAME_ARG))

    init {
        getUserByName()
        getRepositoriesByUserName()
    }

    fun getUserByName() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getUserByNameUseCase(userName)
            },
            onSuccess = {
                setState {
                    copy(
                        loading = false,
                        user = it
                    )
                }
            },
            onFailure = {
                setState { copy(loading = false) }
            }
        )
    }

    fun getRepositoriesByUserName() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getUserRepositoryByName(userName)
            },
            onSuccess = {
                setState {
                    copy(
                        loading = false,
                        repositories = it
                    )
                }
            },
            onFailure = {
                setState { copy(loading = false) }
            }
        )
    }

    companion object {
        const val USER_NAME_ARG = "userName"
    }
}

data class DetailState(
    val loading: Boolean = false,
    val user: User? = null,
    val repositories: List<Repository>? = null
)

sealed interface DetailAction
