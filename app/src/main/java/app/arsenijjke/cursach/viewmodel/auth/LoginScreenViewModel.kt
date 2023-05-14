package app.arsenijjke.cursach.viewmodel.auth

import androidx.lifecycle.ViewModel
import app.arsenijjke.cursach.coordinator.flow.AppFlowCoordinator

class LoginScreenViewModel(
    private val coordinator: AppFlowCoordinator,
) : ViewModel() {

    fun navigateToRegistration() {
        coordinator.navigateToRegistration()
    }

    fun navigateToProfile() {
        coordinator.navigateToProfile()
    }
}