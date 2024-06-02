package com.xische.assignment.repository

import com.xische.assignment.BaseTest
import com.xische.assignment.Constant
import com.xische.core.data.UniversitiesResponse
import com.xische.core.database.UniversityDao
import com.xische.core.network.ApiHelper
import com.xische.core.repository.MainRepository
import com.xische.core.repository.MainRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations.openMocks
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import retrofit2.Response

@RunWith(JUnit4::class)
class MainRepositoryTest : BaseTest() {
    @Mock
    lateinit var apiHelper: ApiHelper

    @Mock
    lateinit var universityDao: UniversityDao

    private lateinit var mainRepository: MainRepository

    @Before
    fun setUp() {
        openMocks(this)
        mainRepository = MainRepositoryImpl(apiHelper, universityDao)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `should give getUniversities with success`() = runTest {
        //given
        val mockResponse = getMockResponse<UniversitiesResponse>(Constant.FILE_PATH_FOR_UNIVERITIES)
        Mockito.`when`(mainRepository.getUniversities()).thenReturn(Response.success(mockResponse))

        //when
        val result = mainRepository.getUniversities()

        //then
        verify(apiHelper, times(1)).getUniversities( "United Arab Emirates")
        assertTrue(result.isSuccessful)
    }
}