package com.hasanakcay.kotlinapp.service

import com.hasanakcay.kotlinapp.model.Album
import com.hasanakcay.kotlinapp.model.Comment
import com.hasanakcay.kotlinapp.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface BaseAPI {

    //https://jsonplaceholder.typicode.com/albums

    @GET("albums")
    fun getAlbums() : Single<List<Album>>

    @GET("photos")
    fun getPhotos() : Single<List<Photo>>

    @GET("comments")
    fun getComments() : Single<List<Comment>>

}