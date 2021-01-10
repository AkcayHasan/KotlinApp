package com.hasanakcay.kotlinapp.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.downloadPhoto(url : String?){

    Picasso.get().load(url).into(this)

}
