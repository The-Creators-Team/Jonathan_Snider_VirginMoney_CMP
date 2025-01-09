package compose.project.demo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoomListRoute
    ) {
        composable<RoomListRoute> {
            RoomScreen(
                navigateToPeopleScreen = { navController.navigate(PeopleListRoute) }
            )
        }
        composable<PeopleListRoute> {
            PeopleScreen(
                navigateToRoomScreen = { navController.navigate(RoomListRoute) }
            )
        }
    }
}

@Serializable
object RoomListRoute

@Serializable
object PeopleListRoute