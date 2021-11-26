package com.ims.runningapp_kotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ims.runningapp_kotlin.db.Run
import com.ims.runningapp_kotlin.repository.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {


    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }

}