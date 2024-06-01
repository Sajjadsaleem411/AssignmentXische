package com.xische.core.network

import com.xische.core.data.UniversitiesResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject
constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUniversities(country: String):
            Response<UniversitiesResponse> = apiService.getUniversityList(country)
}