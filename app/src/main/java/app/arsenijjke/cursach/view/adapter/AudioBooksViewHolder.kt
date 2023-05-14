package app.arsenijjke.cursach.view.adapter

import androidx.recyclerview.widget.RecyclerView
import app.arsenijjke.cursach.databinding.ItemAudioBookBinding
import app.arsenijjke.cursach.model.AudioBook
import org.koin.core.component.KoinComponent

class AudioBooksViewHolder(
    private val binding: ItemAudioBookBinding,
    private val onClick: (AudioBook) -> Unit,
) : RecyclerView.ViewHolder(binding.root), KoinComponent {

    fun bind(item: AudioBook) = with(binding) {
        bookPreview.setImageResource(item.icon)
        authorName.text = item.author
        titleName.text = item.name
        root.setOnClickListener { onClick(item) }
    }
}