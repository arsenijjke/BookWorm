package app.arsenijjke.cursach.view.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenWelcomeBinding
import app.arsenijjke.cursach.viewmodel.auth.WelcomScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeScreen : Fragment(R.layout.screen_welcome) {

    private val binding by viewBinding(ScreenWelcomeBinding::bind)
    private val viewModel by viewModel<WelcomScreenViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(false)
        screenSetup()
    }

    private fun screenSetup() = with(binding) {
        buttonBegin.setOnClickListener { viewModel.navigateToLogin() }
    }

}