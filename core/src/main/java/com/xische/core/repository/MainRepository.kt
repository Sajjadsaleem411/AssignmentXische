package com.xische.core.repository

import com.xische.core.data.UniversitiesResponse
import com.xische.core.data.University
import com.xische.core.network.ApiHelper
import retrofit2.Response
import javax.inject.Inject

interface MainRepository {
    suspend fun getUniversities(): Response<UniversitiesResponse>
}

class MainRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper
) : MainRepository {
    override suspend fun getUniversities(): Response<UniversitiesResponse> {
        return apiHelper.getUniversities("United Arab Emirates")
    }

}