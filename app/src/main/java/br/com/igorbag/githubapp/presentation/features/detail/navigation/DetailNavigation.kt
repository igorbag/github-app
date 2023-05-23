package br.com.igorbag.githubapp.presentation.features.detail.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.igorbag.githubapp.presentation.features.common.Navigation
import br.com.igorbag.githubapp.presentation.features.detail.DetailRoute

object DetailNavigation : Navigation {
    override val route = "detail_route"
    override val destination = "detail_destination"
    const val userNameArg = "userName"
}

fun NavGraphBuilder.detailGraph(onBackClick: () -> Unit) {
    composable(
        route = "${DetailNavigation.route}/{${DetailNavigation.userNameArg}}",
        arguments = listOf(navArgument(DetailNavigation.userNameArg) {
            type = NavType.StringType
        }),
    ) {
        DetailRoute(
            it.arguments ?: bundleOf(),
            onBackClick
        )
    }
}
