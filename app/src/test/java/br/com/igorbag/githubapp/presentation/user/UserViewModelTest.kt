package br.com.igorbag.githubapp.presentation.user

import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.usecase.GetAllUsersUseCase
import br.com.igorbag.githubapp.presentation.TestCoroutineRule
import br.com.igorbag.githubapp.presentation.features.users.UserAction
import br.com.igorbag.githubapp.presentation.features.users.UserViewModel
import br.com.igorbag.githubapp.presentation.features.users.UsersState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UserViewModelTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    private lateinit var viewModel: UserViewModel
    private val getAllUsersUseCase = mockk<GetAllUsersUseCase>()
    private val states = mutableListOf<UsersState>()
    private val actions = mutableListOf<UserAction>()


    @Before
    fun setup() {
        viewModel = UserViewModel(
            getAllUsersUseCase = getAllUsersUseCase,
        )
    }

    @After
    fun cleanup() {
        states.clear()
        actions.clear()
    }

    @Test
    fun `When get users then list of users states`() = runTest {
        coEvery { getAllUsersUseCase() } returns listOf(User("Jhon", "url"))

        val stateJob = launch { viewModel.state.toList(states) }
        val actionJob = launch { viewModel.action.toList(actions) }

        viewModel.getUsers()

        advanceUntilIdle()

        coVerify { getAllUsersUseCase() }

        stateJob.cancel()
        actionJob.cancel()
    }
}
