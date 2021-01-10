package com.hasanakcay.kotlinapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.adapter.CommentAdapter
import com.hasanakcay.kotlinapp.model.Photo
import com.hasanakcay.kotlinapp.viewmodel.PhotoDetailPageViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_photo_detail_page.*

class PhotoDetailPage : Fragment(R.layout.fragment_photo_detail_page) {

    private lateinit var viewModel: PhotoDetailPageViewModel
    private val commentAdapter = CommentAdapter(arrayListOf())

    var photoModelString: String? = ""
    lateinit var photoModel: Photo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PhotoDetailPageViewModel::class.java)
        viewModel.commentsFromJson()

        photoModelString = arguments?.getString("photoModelString")
        photoModel = Gson().fromJson(photoModelString, Photo::class.java)

        Picasso.get().load(photoModel.url).into(photoImg)

        detailRecyclerView2.layoutManager = LinearLayoutManager(context)
        detailRecyclerView2.adapter = commentAdapter

        observeCommentLiveData()
    }

    fun observeCommentLiveData() {
        viewModel.comments.observe(viewLifecycleOwner, Observer { comments ->
            comments?.let {
                commentAdapter.newCommentList(comments.filter { comment -> comment.postId == photoModel.id })
            }
        })
    }

}