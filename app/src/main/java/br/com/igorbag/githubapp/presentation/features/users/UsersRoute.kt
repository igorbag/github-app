package br.com.igorbag.githubapp.presentation.features.users

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.igorbag.githubapp.presentation.features.common.Background
import br.com.igorbag.githubapp.presentation.features.common.LoaderComponent
import br.com.igorbag.githubapp.presentation.features.users.compose.UsersScreen
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UsersRoute(
    navigateToDetail: (String) -> Unit,
    viewModel: UserViewModel = koinViewModel(),
) = Background {
    val state by viewModel.state.collectAsState()

    if (state.loading) {
        LoaderComponent()
    } else {
        UsersScreen(
            users = state.users,
            onDetailClick = navigateToDetail,
        )
    }
}
