package dev.mvillasenor.speedruninfo.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(imageUri: String) {
    Picasso.get().cancelRequest(this)
    if(imageUri.isNotEmpty()) {
        Picasso.get().load(imageUri).into(this)
    }
}
