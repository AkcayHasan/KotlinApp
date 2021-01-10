package com.hasanakcay.kotlinapp.service

import com.hasanakcay.kotlinapp.model.Album
import com.hasanakcay.kotlinapp.model.Comment
import com.hasanakcay.kotlinapp.model.Photo
import com.hasanakcay.kotlinapp.util.Constant.Companion.BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsAPIService {

    private val albumsApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(BaseAPI::class.java)

    fun getData() : Single<List<Album>>{
        return albumsApi.getAlbums()
    }

    fun getPhotos() : Single<List<Photo>>{
        return albumsApi.getPhotos()
    }

    fun getComments() : Single<List<Comment>>{
        return albumsApi.getComments()
    }

}