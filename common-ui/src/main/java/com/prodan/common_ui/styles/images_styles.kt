package com.prodan.common_ui.styles

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import ro.lensa.common.glide.GlideApp

sealed class Image {
    data class Resource(@DrawableRes val resource: Int) : Image()
    data class Network(val url: String) : Image()
}

fun Image.loadImage(imageView: ImageView) {
    when (this) {
        is Image.Resource -> {
            imageView.setImageDrawable(
                AppCompatResources.getDrawable(
                    imageView.context,
                    this.resource
                )
            )
        }

        is Image.Network -> {
            GlideApp.with(imageView)
                .load(this.url)
                .into(imageView)
        }
    }
}

