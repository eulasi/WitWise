package com.example.navbaranalysisone.data.model


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("explicit")
    val explicit: Boolean? = false,
    @SerializedName("nsfw")
    val nsfw: Boolean? = false,
    @SerializedName("political")
    val political: Boolean? = false,
    @SerializedName("racist")
    val racist: Boolean? = false,
    @SerializedName("religious")
    val religious: Boolean? = false,
    @SerializedName("sexist")
    val sexist: Boolean? = false
)