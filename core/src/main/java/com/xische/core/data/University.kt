package com.xische.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "university")
data class University(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    @SerializedName("web_pages")
    val webPages: List<String>
)