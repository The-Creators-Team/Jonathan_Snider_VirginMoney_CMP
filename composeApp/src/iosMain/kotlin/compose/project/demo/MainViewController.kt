package compose.project.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import networking.RoomClient
import networking.createHttpClient

fun MainViewController() = ComposeUIViewController {
    App(
        roomClient = remember {
            RoomClient(createHttpClient(Darwin.create()))
        }
    )
}