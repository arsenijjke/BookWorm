package app.arsenijjke.cursach.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenPlayerBinding
import app.arsenijjke.cursach.util.view.click
import app.arsenijjke.cursach.viewmodel.MediaPlayerScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MediaPlayerScreen : Fragment(R.layout.screen_player) {

    private val binding by viewBinding(ScreenPlayerBinding::bind)
    private val viewModel by viewModel<MediaPlayerScreenViewModel> { parametersOf(arguments) }
    private lateinit var mediaPlayer: MediaPlayer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(false)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        binding.bookTitle.text = viewModel.bookUI.name
        binding.bookImage.setBackgroundResource(viewModel.bookUI.icon)
        binding.end.text = viewModel.bookUI.length.toString()
        mediaPlayer = MediaPlayer.create(requireContext(), viewModel.bookUI.audio)
        btnPause.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mediaPlayer.start()
            } else {
                mediaPlayer.pause()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
