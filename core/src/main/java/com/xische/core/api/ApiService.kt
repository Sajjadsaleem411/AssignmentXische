package com.xische.core.api

import com.xische.core.data.UniversitiesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun getUniversityList(@Query("country") country:String): UniversitiesResponse
}