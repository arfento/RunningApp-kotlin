package com.ims.runningapp_kotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ims.runningapp_kotlin.repository.MainRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
    

}