package br.com.igorbag.githubapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.igorbag.githubapp.presentation.features.users.navigation.UsersNavigation
import br.com.igorbag.githubapp.presentation.features.users.navigation.headsetGraph

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = UsersNavigation.route
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        headsetGraph(
            navigateToDetail = {
//                navController.navigate("${HeadsetDetailNavigation.route}/$it")
            },
            nestedGraphs = {
//                headsetDetailGraph {
//                    navController.popBackStack()
//                }
            }
        )
//        composable("detail") { FriendsListScreen(/*...*/) }
    }
}