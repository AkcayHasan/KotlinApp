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
import kotlinx.android.synthetic.main.albums_detail_comment_row.view.*
import kotlinx.android.synthetic.main.albums_row.view.*
import kotlinx.android.synthetic.main.albums_row.view.albumName

class CommentAdapter(val commentsList : ArrayList<Comment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.albums_detail_comment_row, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        holder.itemView.nameTextView.text = commentsList.get(position).name
        holder.itemView.emailTextView.text = commentsList.get(position).email
        holder.itemView.commentTextView.text = commentsList.get(position).body

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    fun newCommentList(nCommentList : List<Comment>) {
        commentsList.clear()
        commentsList.addAll(nCommentList)
        notifyDataSetChanged()
    }


}