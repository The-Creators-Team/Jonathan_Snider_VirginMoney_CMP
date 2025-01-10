package compose.project.demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import networking.RoomClient
import networking.createHttpClient
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(
    roomClient: RoomClient
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RoomListRoute
    ) {
        composable<RoomListRoute> {
            RoomScreen(
                navigateToPeopleScreen = { navController.navigate(PeopleListRoute) },
                roomClient =roomClient
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