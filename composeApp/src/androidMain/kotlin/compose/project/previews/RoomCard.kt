package compose.project.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Room
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RoomCard(
    room: Room,
) {
    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor =MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .height(80.dp)
                .padding(16.dp),
        ) {

            // Dog Name
            Text(
                text = room.id!!,
            )
            Text(
                text=room.isOccupied.toString()
            )
            Text(
                text=room.maxOccupancy.toString()
            )
        }
    }
}

@Composable
@Preview
fun RoomCardPreview(){
    RoomCard(
        Room(
            id = "12345",
            isOccupied = true,
            maxOccupancy = 12345
        )
    )
}