package com.hasanakcay.kotlinapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.adapter.AlbumsDetailCommentAdapter
import com.hasanakcay.kotlinapp.adapter.AlbumsDetailPhotoAdapter
import com.hasanakcay.kotlinapp.viewmodel.AlbumsDetailPageViewModel
import kotlinx.android.synthetic.main.albums_row.*
import kotlinx.android.synthetic.main.fragment_albums_detail_page.*
import kotlinx.android.synthetic.main.fragment_albums_page.*

class AlbumsDetailPage : Fragment(R.layout.fragment_albums_detail_page) {

    private lateinit var viewModel : AlbumsDetailPageViewModel
    private val photoAdapter = AlbumsDetailPhotoAdapter(arrayListOf())

    var albumId : Int? = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(AlbumsDetailPageViewModel::class.java)
        viewModel.photosFromJson()

        albumId = arguments?.getInt("albumId")

        detailRecyclerView.layoutManager = GridLayoutManager(context,2)
        detailRecyclerView.adapter = photoAdapter

        observePhotoLiveData()
    }

    fun observePhotoLiveData(){
        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            photos?.let {
                photoAdapter.newPhotoList(photos.filter {photo-> photo.albumId==albumId })
            }
        })
    }


}