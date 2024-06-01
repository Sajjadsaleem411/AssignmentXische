package com.xische.core.network

import com.xische.core.data.UniversitiesResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getUniversities(country: String): Response<UniversitiesResponse>
}