package com.xische.assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xische.core.data.UniversitiesResponse
import com.xische.core.models.Resource
import com.xische.core.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DefaultMainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    private val _res = MutableStateFlow<Resource<UniversitiesResponse>>(
        Resource.loading(null)
    )
    val res = _res.asStateFlow()


     fun getUniversities() {
         viewModelScope.launch (Dispatchers.IO){
         _res.value = Resource.loading(null)
             mainRepository.getUniversities().let {
                 try {
                     _res.value = if (it.isSuccessful) {
                         Resource.success(it.body())

                     } else {
                         Resource.error(it.errorBody().toString(), null)
                     }

                 } catch (e: Exception) {
                     Resource.error(it.errorBody().toString(), null)
                 }
             }
         }
    }
}