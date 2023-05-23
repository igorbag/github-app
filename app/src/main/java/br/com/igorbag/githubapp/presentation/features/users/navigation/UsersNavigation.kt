package br.com.igorbag.githubapp.presentation.features.users.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.igorbag.githubapp.presentation.features.common.Navigation
import br.com.igorbag.githubapp.presentation.features.users.UsersRoute

object UsersNavigation : Navigation {
    override val route = "users_route"
    override val destination = "users_destination"
}

fun NavGraphBuilder.headsetGraph(
    navigateToDetail: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = UsersNavigation.route,
        startDestination = UsersNavigation.destination
    ) {
        composable(route = UsersNavigation.destination) {
            UsersRoute(
                navigateToDetail = navigateToDetail,
            )
        }
        nestedGraphs()
    }
}
