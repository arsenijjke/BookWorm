package app.arsenijjke.cursach.viewmodel.auth

import androidx.lifecycle.ViewModel
import app.arsenijjke.cursach.coordinator.flow.AppFlowCoordinator

class WelcomScreenViewModel(
    private val coordinator: AppFlowCoordinator,
) : ViewModel() {

    fun navigateToLogin() = coordinator.navigateToLogin()

}