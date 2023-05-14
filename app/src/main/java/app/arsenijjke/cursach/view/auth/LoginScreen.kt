package app.arsenijjke.cursach.view.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenLoginBinding
import app.arsenijjke.cursach.util.view.click
import app.arsenijjke.cursach.viewmodel.auth.LoginScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginScreen : Fragment(R.layout.screen_login) {

    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel by viewModel<LoginScreenViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenSetup()
        (activity as MainActivity).setNavigationVisibilisty(false)
    }

    private fun screenSetup() = with(binding) {
        btnLogin.click { viewModel.navigateToProfile() }
        registration.click { viewModel.navigateToRegistration() }
    }

}
