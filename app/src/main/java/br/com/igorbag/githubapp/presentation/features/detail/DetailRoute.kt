package br.com.igorbag.githubapp.presentation.features.detail

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.igorbag.githubapp.presentation.features.common.Background
import br.com.igorbag.githubapp.presentation.features.common.LoaderComponent
import br.com.igorbag.githubapp.presentation.features.detail.compose.DetailScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun DetailRoute(
    bundle: Bundle,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = getViewModel(parameters = { parametersOf(bundle) })
) = Background {
    val state by viewModel.state.collectAsState()

    if (state.loading) {
        LoaderComponent()
    } else {
        state.user?.let {
            DetailScreen(
                user = it,
                repositories = state.repositories,
                onBackClick = onBackClick
            )
        }
    }
}
