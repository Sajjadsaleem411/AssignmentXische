package com.xische.core.data

import com.google.gson.annotations.SerializedName

data class University(
    val id: Int,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    @SerializedName("state-province")
    val stateProvince: String,
    @SerializedName("web_pages")
    val webPages: List<String>
)