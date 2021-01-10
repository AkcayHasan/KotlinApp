package com.hasanakcay.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.model.Album
import com.hasanakcay.kotlinapp.model.Comment
import com.hasanakcay.kotlinapp.view.AlbumsPageDirections
import kotlinx.android.synthetic.main.albums_row.view.*

class AlbumsAdapter(val albumsList: ArrayList<Album>) : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    inner class AlbumsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.albums_row, parent, false)
        return AlbumsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {

        holder.itemView.albumName.text = albumsList.get(position).title

        holder.itemView.albumName.setOnClickListener {
            val bundle = bundleOf("albumId" to albumsList.get(position).id)
            Navigation.findNavController(it).navigate(R.id.albumsDetailPage,bundle)
        }
    }

    override fun getItemCount(): Int {
        return albumsList.size
    }

    fun newAlbumList(nAlbumList : List<Album>) {
        albumsList.clear()
        albumsList.addAll(nAlbumList)
        notifyDataSetChanged()
    }


}