package app.arsenijjke.cursach.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import app.arsenijjke.cursach.MainActivity
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ScreenPlayerBinding
import app.arsenijjke.cursach.util.view.click
import app.arsenijjke.cursach.viewmodel.MediaPlayerScreenViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.concurrent.TimeUnit

class MediaPlayerScreen : Fragment(R.layout.screen_player) {

    private val binding by viewBinding(ScreenPlayerBinding::bind)
    private val viewModel by viewModel<MediaPlayerScreenViewModel> { parametersOf(arguments) }
    private lateinit var mediaPlayer: MediaPlayer

    private var timerJob: Job? = null
    private var isTimerPaused: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setNavigationVisibilisty(false)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        bookTitle.text = viewModel.bookUI.name
        bookImage.setBackgroundResource(viewModel.bookUI.icon)
        end.text = formatDuration(viewModel.bookUI.length)
        btnBack.click { viewModel.navigateToBack() }

        moveForward()
        moveBackward()

        mediaPlayer = MediaPlayer.create(requireContext(), viewModel.bookUI.audio)
        progress.max = mediaPlayer.duration
        btnPause.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mediaPlayer.start()
                doOnce()
                resumeTimer()
            } else {
                mediaPlayer.pause()
                stopTimer()
                pauseTimer()
            }
        }
    }
    private fun moveForward() {
        binding.btnToUpload.click {
            val currentPosition = mediaPlayer.currentPosition
            val newPosition = currentPosition + 10000
            mediaPlayer.seekTo(newPosition)
        }
    }

    private fun moveBackward() {
        binding.btnToReload.click {
            val currentPosition = mediaPlayer.currentPosition
            val newPosition = currentPosition - 10000
            mediaPlayer.seekTo(newPosition)
        }
    }

    fun doOnce() {
        var i = 0
        if(i == 0){
            startTimer()
            i++
        }
    }

    private fun startTimer() {
        timerJob = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                if (!isTimerPaused) {
                    updateTimer()
                }
                delay(1000) // Delay for one second
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }

    private fun pauseTimer() {
        isTimerPaused = true
    }

    private fun resumeTimer() {
        isTimerPaused = false
    }

    private fun updateTimer() {
        if (mediaPlayer.isPlaying) {
            val currentPosition = mediaPlayer.currentPosition
            binding.progress.progress = currentPosition
            binding.start.text = formatTime(currentPosition)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun formatDuration(duration: Int): String {
        val hours = duration / 3600
        val minutes = (duration % 3600) / 60
        val seconds = duration % 60

        return if (hours > 0) {
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format("%02d:%02d", minutes, seconds)
        }
    }

    private fun formatTime(timeInMillis: Int): String {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis.toLong())
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis.toLong()) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
