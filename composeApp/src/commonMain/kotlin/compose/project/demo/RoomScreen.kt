package compose.project.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import networking.RoomClient
import util.onError
import util.onSuccess

@Composable
fun RoomScreen(
    roomClient: RoomClient,
    navigateToPeopleScreen: () -> Unit
) {
    val scope= rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Button(
                onClick = {
                    scope.launch {
                        println("DOING API CALL")
                        roomClient.getRooms()
                            .onSuccess {
                                println("PRINTING SUCCESS")
                                println(it)
                            }
                            .onError {
                                println("PRINTING ERROR")
                                println(it)
                            }
                    }
                }
            ) {
                Text("Make API call")
            }
            Button(
                onClick = navigateToPeopleScreen
            ) {
                Text("Go To People Screen")
            }
        }
    }
}