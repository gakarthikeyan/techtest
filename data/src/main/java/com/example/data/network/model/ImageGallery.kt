package com.example.data.network.model


import com.google.gson.annotations.SerializedName

data class ImageGallery(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("src")
    val src: String = "",
    @SerializedName("title")
    val title: String = ""
)