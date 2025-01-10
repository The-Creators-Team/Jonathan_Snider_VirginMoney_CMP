package repository

import model.Room
import util.NetworkError
import util.Result

interface RoomRepository {
    suspend fun getRooms(): Result<List<Room>, NetworkError>
}