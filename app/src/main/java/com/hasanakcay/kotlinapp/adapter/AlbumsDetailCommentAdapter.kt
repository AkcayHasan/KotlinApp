package com.hasanakcay.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.model.Comment
import kotlinx.android.synthetic.main.albums_detail_comment_row.view.*

class AlbumsDetailCommentAdapter (val commentList : ArrayList<Comment>) : RecyclerView.Adapter<AlbumsDetailCommentAdapter.DetailCommentViewHolder>() {
    inner class DetailCommentViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.albums_detail_comment_row,parent,false)
        return DetailCommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailCommentViewHolder, position: Int) {
        holder.itemView.nameTextView.text = commentList.get(position).name
        holder.itemView.emailTextView.text = commentList.get(position).email
        holder.itemView.commentTextView.text = commentList.get(position).body

    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    fun newCommentList(nCommentList : List<Comment>){
        commentList.clear()
        commentList.addAll(nCommentList)
        notifyDataSetChanged()
    }
}