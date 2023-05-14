package app.arsenijjke.cursach.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import app.arsenijjke.cursach.R
import app.arsenijjke.cursach.model.Genre

class GeneresAdapter(
    private val genresList: List<Genre>,
) : RecyclerView.Adapter<GeneresAdapter.GenresViewHolder>() {


    class GenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.icon_to_catalog)
        val textView: TextView = itemView.findViewById(R.id.genre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catalog, parent, false)
        return GenresViewHolder(view)
    }

    override fun getItemCount(): Int = genresList.size

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genre = genresList[position]
        holder.imageView.setImageResource(genre.icon)
        holder.textView.text = genre.subtitle
    }
}