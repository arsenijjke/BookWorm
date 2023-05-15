package app.arsenijjke.cursach.viewmodel

import androidx.lifecycle.ViewModel
import app.arsenijjke.cursach.coordinator.flow.IAppFlowCoordinator
import app.arsenijjke.cursach.model.AudioBook

class MediaPlayerScreenViewModel(
    private val coordinator: IAppFlowCoordinator,
    private val book: AudioBook,
) : ViewModel() {

    val bookUI = book

    fun navigateToBack() {
        coordinator.back()
    }
}