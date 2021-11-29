package com.ims.runningapp_kotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ims.runningapp_kotlin.repository.MainRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    val totalTimeRun = mainRepository.getTotalTimeInMillis()
    val totalDistance = mainRepository.getTotalDistance()
    val totalCaloriesBurned = mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = mainRepository.getTotalAvgSpeed()
    val runSortedByDate = mainRepository.getAllRunSortedByDate()


}