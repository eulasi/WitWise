package com.example.navbaranalysisone.data.model


import com.google.gson.annotations.SerializedName

data class EndPtOneModelItem(
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("linecount")
    val linecount: String? = "",
    @SerializedName("lines")
    val lines: List<String?>? = listOf(),
    @SerializedName("title")
    val title: String? = ""
)