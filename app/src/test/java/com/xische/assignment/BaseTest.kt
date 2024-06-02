package com.xische.assignment

import com.google.gson.Gson
import java.io.File

open class BaseTest {

    inline fun <reified T> getMockResponse(filePath: String): T {
        val fileJson = File(filePath).readText()
        val gson = Gson()
        return gson.fromJson(fileJson, T::class.java)
    }
}