package app.arsenijjke.cursach.view.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.model.AudioBook
import app.arsenijjke.cursach.databinding.ScreenMyBooksBinding
import app.arsenijjke.cursach.util.view.RecyclerViewMarginDecorator
import app.arsenijjke.cursach.view.adapter.AudioBooksAdapter
import app.arsenijjke.cursach.viewmodel.profile.MyBooksScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyBooksScreen : Fragment(R.layout.screen_my_books) {

    private val binding by viewBinding(ScreenMyBooksBinding::bind)
    private val viewModel by viewModel<MyBooksScreenViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(true)
        setupView()
    }

    private fun setupView() = with(binding) {
        toolbar.title.text = "Мои книги"
        newbies.layoutManager = LinearLayoutManager(requireContext(), androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        newbies.addItemDecoration(RecyclerViewMarginDecorator(10))
        val adapter = AudioBooksAdapter(viewModel::navigateToSong)
        newbies.adapter = adapter.also { it.submitList(audioBooks) }

        favorites.layoutManager = LinearLayoutManager(requireContext(), androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        favorites.addItemDecoration(RecyclerViewMarginDecorator(10))
        val adapterFav = AudioBooksAdapter(viewModel::navigateToSong)
        favorites.adapter = adapterFav.also { it.submitList(favoriteBooks) }

    }

    private val audioBooks = listOf(
        AudioBook("1","После бала", "Лев Толстой", R.drawable.posle_bala, 3511, R.raw.posle_bala),
        AudioBook("2","Морковка для гнедого", "Дик Френсис", R.drawable.gnedogo, 1601, R.raw.gnedogo),
        AudioBook("3","Брошь", "Уильям Фолкнер", R.drawable.brosh, 2520, R.raw.brosh),
        AudioBook("4","После бала", "Лев Толстой", R.drawable.posle_bala, 2511000, R.raw.posle_bala),
        AudioBook("5","После бала", "Лев Толстой", R.drawable.posle_bala, 1511000, R.raw.posle_bala),
        AudioBook("6","Коллекционер", "Клиффорд Саймак", R.drawable.collect, 5511000, R.raw.posle_bala),
        AudioBook("7","Богатый папа - бедный папа", "Роберт Кийосаки", R.drawable.img, 5511000, R.raw.posle_bala),
        AudioBook("8","Оно", "Стивен Кинг", R.drawable.img_1, 5711000, R.raw.posle_bala),
    )

    private val favoriteBooks = listOf(
        AudioBook("1","После бала", "Лев Толстой", R.drawable.posle_bala, 3511, R.raw.posle_bala),
        AudioBook("2","Коллекционер", "Клиффорд Саймак", R.drawable.collect, 5511000, R.raw.posle_bala),
        AudioBook("3","Богатый папа - бедный папа", "Роберт Кийосаки", R.drawable.img, 5511000, R.raw.posle_bala),
        AudioBook("4","Оно", "Стивен Кинг", R.drawable.img_1, 5711000, R.raw.posle_bala),
            AudioBook("5","Зов Ктулху", "Говард Лавкрафт", R.drawable.img_2, 5711000, R.raw.posle_bala),

    )
}