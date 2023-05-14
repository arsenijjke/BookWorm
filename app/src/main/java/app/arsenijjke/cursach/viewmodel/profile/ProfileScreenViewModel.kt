package app.arsenijjke.cursach.viewmodel.profile

import androidx.lifecycle.ViewModel
import app.arsenijjke.cursach.coordinator.flow.AppFlowCoordinator
import app.arsenijjke.cursach.coordinator.flow.IAppFlowCoordinator
import app.arsenijjke.cursach.model.AudioBook

class ProfileScreenViewModel(
    private val coordinator: IAppFlowCoordinator,
) : ViewModel() {

    fun navigateToSong(book: AudioBook) {
        coordinator.navigateToAudioBook(book)
    }
}