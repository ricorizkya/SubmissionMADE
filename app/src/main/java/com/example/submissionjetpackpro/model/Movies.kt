package com.example.submissionjetpackpro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var title: String? = null,
    var description: String? = null,
    var genre: String? = null,
    var timeRelease: String? = null,
    var rating: String? = null,
    var imagePhoto: String? = null
):Parcelable