package app.arsenijjke.cursach.coordinator.flow

import app.arsenijjke.cursach.model.AudioBook

interface IAppFlowCoordinator {

    fun navigateToRegistration()

    fun navigateToProfile()

    fun back()

    fun navigateToCatalog()

    fun navigateToInteresting()

    fun navigateToMyBooks()

    fun navigateToLogin()

    fun navigateToAudioBook(book: AudioBook)
}