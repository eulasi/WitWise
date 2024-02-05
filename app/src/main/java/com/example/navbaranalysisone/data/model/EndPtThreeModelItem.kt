package com.example.navbaranalysisone.data.model


import com.google.gson.annotations.SerializedName

data class EndPtThreeModelItem(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("authorSlug")
    val authorSlug: String? = "",
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("dateAdded")
    val dateAdded: String? = "",
    @SerializedName("dateModified")
    val dateModified: String? = "",
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("length")
    val length: Int? = 0,
    @SerializedName("tags")
    val tags: List<String?>? = listOf()
)