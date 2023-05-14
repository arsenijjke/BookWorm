package app.arsenijjke.cursach.coordinator.flow

import app.arsenijjke.cursach.coordinator.screens.AppScreens
import app.arsenijjke.cursach.model.AudioBook
import com.github.terrakok.cicerone.Router

class AppFlowCoordinator(
    private val router: Router,
) : IAppFlowCoordinator {

    override fun navigateToRegistration() {
        router.navigateTo(AppScreens.registrationScreen)
    }

    override fun navigateToProfile() {
        router.navigateTo(AppScreens.profileScreem)
    }

    override fun back() {
        router.exit()
    }

    override fun navigateToCatalog() {
        router.navigateTo(AppScreens.catalogScreen)
    }

    override fun navigateToInteresting() {
        router.navigateTo(AppScreens.interestingScreen)
    }

    override fun navigateToMyBooks() {
        router.navigateTo(AppScreens.myBooksScreen)
    }

    override fun navigateToLogin() {
        router.navigateTo(AppScreens.loginScreen)
    }

    override fun navigateToAudioBook(book: AudioBook) {
        router.navigateTo(AppScreens.buildMediaPlayerScreen(book))
    }
}