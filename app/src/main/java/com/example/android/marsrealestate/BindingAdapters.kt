/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageURL")
fun ImageView.bindImage(imgURL: String?) {

    imgURL?.let {

        val imgUri =
                it.toUri()
                        .buildUpon()
                        .scheme("https")
                        .build()

        Glide.with(this)
                .load(imgUri)
                .apply(
                        RequestOptions().placeholder(R.drawable.loading_animation)
                                .error(R.drawable.ic_broken_image))
                .into(this)
    }
}


@BindingAdapter("imageURLCoil")
fun ImageView.bindImageUsingCoil(imgURL: String?) {

    imgURL?.let {

        val imageUri =
                it.toUri()
                        .buildUpon()
                        .scheme("https")
                        .build()
        load(imageUri){placeholder(R.drawable.loading_animation)
        //crossfade(true)
            error(R.drawable.ic_broken_image)
           transformations( RoundedCornersTransformation(12f))
           transformations( GrayscaleTransformation())
        }
    }
}

