package br.com.gustavomonteiro.deputado.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadUrlRounded(url: String) {

    Glide.with(context)
        .load(url)
        .transform(CenterCrop(), RoundedCorners(240))
        .into(this)
}

fun ImageView.loadUrl(url: String) {

    Glide.with(context)
        .load(url)
        .into(this)
}
