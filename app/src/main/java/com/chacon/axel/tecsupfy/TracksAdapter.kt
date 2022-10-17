package com.chacon.axel.tecsupfy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.chacon.axel.tecsupfy.databinding.ItemSongBinding
import de.hdodenhof.circleimageview.CircleImageView

class TracksAdapter(
    private val listSong: List<Song>
): RecyclerView.Adapter<TracksAdapter.TrackViewHolder>() {

    class TrackViewHolder(
        private val binding: ItemSongBinding
    ): RecyclerView.ViewHolder(binding.root){
        val coverImage: ImageView = binding.coverImage
        val songName: TextView = binding.songNameText
        val artist: TextView = binding.artistsText
        val duration: TextView = binding.durationText
        val genre: TextView = binding.genreText
        val favorite: ImageView = binding.favorite
        val play: CircleImageView = binding.btnPlay
        val pause: CircleImageView = binding.btnPause
        val share: ImageButton = binding.btnShare
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val itemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(itemSongBinding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val song: Song =listSong[position]
        val context = holder.itemView.context
        val idRes = context.resources.getIdentifier(song.picture, "drawable", context.packageName)

        holder.songName.text = song.name
        holder.artist.text = song.artist
        holder.duration.text = song.duration
        holder.genre.text = song.genre
        holder.coverImage.setImageResource(idRes)

        if (song.genre == "Rock"){
            holder.favorite.visibility = View.VISIBLE
        }

        holder.play.setOnClickListener{
            Toast.makeText(context, "Playing: ${song.name} by ${song.artist}", Toast.LENGTH_SHORT).show()
        }

        holder.pause.setOnClickListener{
            Toast.makeText(context, "You paused: ${song.name} by ${song.artist}", Toast.LENGTH_SHORT).show()
        }

        holder.share.setOnClickListener{
            val songName = song.name
            val artist = song.artist

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(Intent.EXTRA_TEXT, "Escucha $songName de $artist en #TecsupFy!")

            ContextCompat.startActivity(context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return listSong.size
    }
}