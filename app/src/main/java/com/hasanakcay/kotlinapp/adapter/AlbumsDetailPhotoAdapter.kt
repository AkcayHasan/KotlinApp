package com.hasanakcay.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.model.Photo
import com.hasanakcay.kotlinapp.util.downloadPhoto
//import com.hasanakcay.kotlinapp.util.downloadPhoto
//import com.hasanakcay.kotlinapp.util.doPlaceHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.albums_detail_photo_row.view.*
import kotlinx.android.synthetic.main.albums_row.view.*
import kotlinx.android.synthetic.main.fragment_entry_page.view.*

class AlbumsDetailPhotoAdapter (val photoList : ArrayList<Photo>): RecyclerView.Adapter<AlbumsDetailPhotoAdapter.DetailPhotoViewHolder>() {
    inner class DetailPhotoViewHolder (itemview : View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.albums_detail_photo_row,parent,false)
        return DetailPhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailPhotoViewHolder, position: Int) {

        holder.itemView.img_photo_item.downloadPhoto(photoList.get(position).thumbnailUrl)
        holder.itemView.tv_photo_title.text = photoList.get(position).title

        holder.itemView.setOnClickListener {
            val photoModelString= Gson().toJson(photoList.get(position)).toString()
            val bundle = bundleOf("photoModelString" to photoModelString)
            Navigation.findNavController(it).navigate(R.id.photoDetailPage,bundle)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun newPhotoList(nPhotoList : List<Photo>){
        photoList.clear()
        photoList.addAll(nPhotoList)
        notifyDataSetChanged()
    }
}