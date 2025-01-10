package compose.project.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import model.Room
import networking.RoomClient
import util.onError
import util.onSuccess

@Composable
fun RoomScreen(
    roomClient: RoomClient,
    navigateToPeopleScreen: () -> Unit
) {
    val scope = rememberCoroutineScope()

    var roomList by remember { mutableStateOf(emptyList<Room>()) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn {
            items(roomList.size) { room ->
                RoomCard(
                    room = roomList[room]
                )
            }
        }
        if (roomList.isEmpty()) {
            Text(text = "waiting for room")
        }

        Column {
            Button(
                onClick = {
                    scope.launch {
                        println("DOING API CALL")
                        roomClient.getRooms()
                            .onSuccess {
                                println("PRINTING SUCCESS")
                                roomList = it
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
                onClick = {
                    println("PRINTING ROOM LIST")
                    println(roomList[0])
                }
            ) {
                Text("Test room list")
            }
            Button(
                onClick = navigateToPeopleScreen
            ) {
                Text("Go To People Screen")
            }
        }
    }
}

@Composable
fun RoomCard(
    room: Room,
) {
    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .height(120.dp)
                .padding(16.dp),
        ) {
            Text(
                text = room.id!!,
            )
            Text(
                text = room.isOccupied.toString()
            )
            Text(
                text = room.maxOccupancy.toString()
            )
        }
    }
}