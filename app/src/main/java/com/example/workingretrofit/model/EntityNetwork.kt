package com.example.workingretrofit.model

import com.squareup.moshi.Json

data class EntityNetwork(
    var price: Double,
    val id: String,
    var type: String,
    @Json(name = "img_src")
    var imgSrc: String
) {
}