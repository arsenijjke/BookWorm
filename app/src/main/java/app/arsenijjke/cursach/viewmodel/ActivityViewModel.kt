package app.arsenijjke.cursach.viewmodel

import androidx.lifecycle.ViewModel
import app.arsenijjke.cursach.coordinator.flow.IAppFlowCoordinator

class ActivityViewModel(
    private val coordinator: IAppFlowCoordinator
) : ViewModel() {

    fun navigateToInteresting() {
        coordinator.navigateToInteresting()
    }

    fun navigateToMyBooks() {
        coordinator.navigateToMyBooks()
    }

    fun navigateToCatalog() {
        coordinator.navigateToCatalog()
    }

    fun navigateToProfile() {
        coordinator.navigateToProfile()
    }
}