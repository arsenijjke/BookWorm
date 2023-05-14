package app.arsenijjke.cursach.view.profile

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenProfileBinding
import app.arsenijjke.cursach.model.AudioBook
import app.arsenijjke.cursach.util.view.RecyclerViewMarginDecorator
import app.arsenijjke.cursach.view.adapter.AudioBooksAdapter
import app.arsenijjke.cursach.view.adapter.GeneresAdapter
import app.arsenijjke.cursach.viewmodel.profile.ProfileScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileScreen : Fragment(R.layout.screen_profile) {

    private val binding by viewBinding(ScreenProfileBinding::bind)
    private val viewModel by viewModel<ProfileScreenViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(true)
        setupView()
    }

    private fun setupView() = with(binding) {
        toolbar.title.text = "Мой профиль"
        newbies.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        newbies.addItemDecoration(RecyclerViewMarginDecorator(10))
        val adapter = AudioBooksAdapter(viewModel::navigateToSong)
        newbies.adapter = adapter.also { it.submitList(audioBooks) }

    }

    private val audioBooks = listOf(
        AudioBook("1","После бала", "Лев Толстой", R.drawable.posle_bala, 1601, R.raw.posle_bala),
        AudioBook("2","Морковка для гнедого", "Дик Френсис", R.drawable.img, 1601, R.raw.gnedogo),
        AudioBook("3","Брошь", "Уильям Фолкнер", R.drawable.brosh, 5901, R.raw.brosh),
        AudioBook("4","После бала", "Лев Толстой", R.drawable.posle_bala, 1601, R.raw.posle_bala),
        AudioBook("5","После бала", "Лев Толстой", R.drawable.posle_bala, 1601, R.raw.posle_bala),
    )
}