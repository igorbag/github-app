package br.com.igorbag.githubapp.presentation.features.users

import androidx.lifecycle.viewModelScope
import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.usecase.GetAllUsersUseCase
import br.com.igorbag.githubapp.presentation.core.BaseViewModel
import br.com.igorbag.githubapp.presentation.core.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val getAllUsersUseCase: GetAllUsersUseCase,
) : BaseViewModel<UsersState, UserAction>(UsersState()) {

    init {
        getHeadsets()
    }

    private fun getHeadsets() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(dispatcher = Dispatchers.Default, execute = {
            getAllUsersUseCase()
        }, onSuccess = {
            setState { copy(loading = false, users = it) }
        }, onFailure = {
            setState { copy(loading = false) }
        })
    }
}

data class UsersState(
    val loading: Boolean = false, val users: List<User> = emptyList()
)

sealed interface UserAction
