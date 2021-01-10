package com.hasanakcay.kotlinapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasanakcay.kotlinapp.model.Album
import com.hasanakcay.kotlinapp.service.AlbumsAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AlbumsPageViewModel : ViewModel() {

    val albums = MutableLiveData<List<Album>>()

    private val albumsApiService = AlbumsAPIService()
    private val disposable = CompositeDisposable()

    fun dataFromJson(){
        disposable.add(
            albumsApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Album>>(){
                    override fun onSuccess(t: List<Album>) {
                        albums.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}