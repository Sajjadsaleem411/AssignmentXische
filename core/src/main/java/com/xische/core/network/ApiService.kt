package com.xische.core.network

import com.xische.core.data.UniversitiesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Login service Retrofit API.
 */
interface ApiService{

    @GET("search")
    suspend fun getUniversityList(@Query("country") country:String): Response<UniversitiesResponse>

}