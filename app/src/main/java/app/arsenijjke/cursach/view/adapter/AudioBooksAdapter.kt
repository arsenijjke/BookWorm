package app.arsenijjke.cursach.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.databinding.ItemAudioBookBinding
import app.arsenijjke.cursach.model.AudioBook

class AudioBooksAdapter(
    private val onClick: (AudioBook) -> Unit,
) : ListAdapter<AudioBook, AudioBooksViewHolder>(AudioBook.diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioBooksViewHolder {
        return AudioBooksViewHolder(
            onClick = onClick,
            binding = ItemAudioBookBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_audio_book, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: AudioBooksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}