package app.arsenijjke.cursach.view.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R

class InterestingScreen : Fragment(R.layout.screen_interesting) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(true)
    }
}