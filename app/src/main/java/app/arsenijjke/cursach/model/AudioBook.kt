package app.arsenijjke.cursach.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioBook(
    val id: String,
    val name: String,
    val author: String,
    val icon: Int,
    val length: Int,
    val audio: Int,
) : Parcelable {

    companion object {
        const val KEY = "book"

        val diffCallback = object : DiffUtil.ItemCallback<AudioBook>() {
            override fun areItemsTheSame(
                oldItem: AudioBook,
                newItem: AudioBook
            ) =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: AudioBook,
                newItem: AudioBook
            ) =
                oldItem == newItem
        }
    }
}
