package compose.project.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.ktor.client.engine.okhttp.OkHttp
import networking.RoomClient
import networking.createHttpClient

fun main() = application {
    val state = rememberWindowState(
        size = DpSize(400.dp, 250.dp),
        position = WindowPosition(300.dp, 300.dp)
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposeDemo",
    ) {
        App(
            roomClient = remember{
                RoomClient(createHttpClient(OkHttp.create()))
            }
        )
    }
}