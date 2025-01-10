package repository

import model.Room
import networking.RoomClient
import util.NetworkError
import util.Result

class RoomRepositoryImpl(val roomClient: RoomClient) : RoomRepository {
    override suspend fun getRooms(): Result<List<Room>, NetworkError> {
        return roomClient.getRooms()
    }
}
