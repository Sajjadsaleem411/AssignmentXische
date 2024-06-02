package com.xische.assignment
import com.xische.assignment.Constant.FILE_PATH_FOR_UNIVERITIES
import com.xische.core.data.UniversitiesResponse
import com.xische.core.network.ApiHelperImpl
import com.xische.core.network.ApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class ApiHelperImplTest : BaseTest() {

    @Mock
    lateinit var apiHelper: ApiService
    private lateinit var apiHelperImpl: ApiHelperImpl


    @Before
    fun setup() {
        apiHelperImpl = ApiHelperImpl(apiHelper)
    }

    @Test
    fun shouldReturnList() = runTest {
        // given
        val mockResponse = getMockResponse<UniversitiesResponse>(FILE_PATH_FOR_UNIVERITIES)
        Mockito.`when`(apiHelper.getUniversityList("")).thenReturn(Response.success(mockResponse))

        // when
        val result = apiHelperImpl.getUniversities("")
        verify(apiHelper, times(1)).getUniversityList("")

        // then
        Assert.assertTrue(result.isSuccessful)
        Assert.assertTrue(result.body() != null)
        result.body()?.apply {
            Assert.assertTrue(count() == 37)
            Assert.assertEquals(this.getOrNull(1)?.name, "American College Of Dubai")
        }
    }

}