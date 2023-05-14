package app.arsenijjke.cursach.view.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenCatalogBinding
import app.arsenijjke.cursach.model.Genre
import app.arsenijjke.cursach.util.view.RecyclerViewMarginDecorator
import app.arsenijjke.cursach.view.adapter.GeneresAdapter
import app.arsenijjke.cursach.viewmodel.profile.CatalogScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogScreen : Fragment(R.layout.screen_catalog) {

    private val binding by viewBinding(ScreenCatalogBinding::bind)
    private val viewModel by viewModel<CatalogScreenViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(true)
        setupRecycler()
    }

    private fun setupRecycler() = with(binding) {
        recycler.layoutManager = GridLayoutManager(requireContext(), 3)
        recycler.addItemDecoration(RecyclerViewMarginDecorator(10))
        recycler.adapter = GeneresAdapter(genresList)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private val genresList: List<Genre> = listOf(
        Genre(R.drawable.icon_nature, "Исторические"),
        Genre(R.drawable.icon_sad, "Драки"),
        Genre(R.drawable.icon_nature, "Средневековье"),
        Genre(R.drawable.icon_nature, "Мексиканские"),
        Genre(R.drawable.icon_nature, "Психологические"),
        Genre(R.drawable.icon_sport, "Боевики"),
        Genre(R.drawable.icon_sad, "Космос"),
        Genre(R.drawable.icon_sport, "Спорт"),
        Genre(R.drawable.icon_nature, "Приключенческие"),
    )
}