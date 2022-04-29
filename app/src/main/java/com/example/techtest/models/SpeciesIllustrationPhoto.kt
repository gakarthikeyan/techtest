package com.example.techtest.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class SpeciesIllustrationPhoto(
    @SerializedName("alt")
    @Expose
    val alt: String?,
    @SerializedName("src")
    @Expose
    val src: String?,
    @SerializedName("title")
    @Expose
    val title: String?
)