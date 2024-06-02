package com.xische.core.repository

import com.xische.core.data.UniversitiesResponse
import com.xische.core.data.University
import com.xische.core.database.UniversityDao
import com.xische.core.network.ApiHelper
import retrofit2.Response
import javax.inject.Inject

interface MainRepository {
    suspend fun getUniversities(): Response<UniversitiesResponse>
    suspend fun saveUniversities(universities: List<University>)
}

class MainRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val universityDao: UniversityDao
) : MainRepository {
    override suspend fun getUniversities(): Response<UniversitiesResponse> {
        return try {
            apiHelper.getUniversities("United Arab Emirates")
        }catch (e:Exception){
            e.stackTrace
            val daoResponse = UniversitiesResponse()
            daoResponse.addAll(universityDao.getUniversities())
            Response.success(daoResponse)
            Response.success(daoResponse)
        }
    }

    override suspend fun saveUniversities(universities: List<University>) {
        universityDao.insertAll(universities)
    }
}