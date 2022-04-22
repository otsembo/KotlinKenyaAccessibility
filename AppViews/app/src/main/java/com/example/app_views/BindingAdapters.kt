package com.example.app_views

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageResource")
fun ImageView.setImage(resource:Int){
    load(resource)
}