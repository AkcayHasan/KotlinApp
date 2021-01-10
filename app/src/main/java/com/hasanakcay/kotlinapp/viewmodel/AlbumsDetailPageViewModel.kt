package com.hasanakcay.kotlinapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasanakcay.kotlinapp.model.Photo
import com.hasanakcay.kotlinapp.service.AlbumsAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AlbumsDetailPageViewModel : ViewModel(){

    val photos = MutableLiveData<List<Photo>>()

    private val photosApiService = AlbumsAPIService()
    private val disposable = CompositeDisposable()

    fun photosFromJson(){
        disposable.add(
            photosApiService.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Photo>>(){
                    override fun onSuccess(t: List<Photo>) {
                        photos.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

}