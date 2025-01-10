package viewmodel

import androidx.lifecycle.ViewModel
import repository.RoomRepositoryImpl

class RoomViewModel(
    val repositoryImpl: RoomRepositoryImpl
) : ViewModel()  {


}