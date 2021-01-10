package com.hasanakcay.kotlinapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasanakcay.kotlinapp.model.Comment
import com.hasanakcay.kotlinapp.service.AlbumsAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PhotoDetailPageViewModel : ViewModel(){

    val comments = MutableLiveData<List<Comment>>()

    private val commentApiService = AlbumsAPIService()
    private val disposable = CompositeDisposable()

    fun commentsFromJson(){
        disposable.add(
            commentApiService.getComments()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Comment>>(){
                    override fun onSuccess(t: List<Comment>) {
                        comments.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }


}