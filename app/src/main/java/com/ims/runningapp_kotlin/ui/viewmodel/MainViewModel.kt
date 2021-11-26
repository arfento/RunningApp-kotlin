package com.ims.runningapp_kotlin.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ims.runningapp_kotlin.db.Run
import com.ims.runningapp_kotlin.repository.MainRepository
import com.ims.runningapp_kotlin.utilities.SortType
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    val runSortedByDate = mainRepository.getAllRunSortedByDate()
    val runSortedByDistance = mainRepository.getAllRunSortedByDistance()
    val runSortedByCaloriesBurned = mainRepository.getAllRunSortedByCaloriesBurned()
    val runSortedByTimeInMillis = mainRepository.getAllRunSortedByTimeInMillis()
    val runSortedByAvgSpeed = mainRepository.getAllRunSortedByAvgSpeed()

    val runs = MediatorLiveData<List<Run>>()

    var sortType = SortType.DATE

    init{
        runs.addSource(runSortedByDate){ result ->
            if (sortType == SortType.DATE){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByAvgSpeed){ result ->
            if (sortType == SortType.AVG_SPEED){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByCaloriesBurned){ result ->
            if (sortType == SortType.CALORIES_BURNED){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByDistance){ result ->
            if (sortType == SortType.DISTANCE){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByTimeInMillis){ result ->
            if (sortType == SortType.RUNNING_TIME){
                result?.let { runs.value = it }
            }
        }
    }

    fun sortRuns(sortType: SortType) = when(sortType){
        SortType.DATE -> runSortedByDate.value?.let { runs.value = it }
        SortType.RUNNING_TIME -> runSortedByTimeInMillis.value?.let { runs.value = it }
        SortType.AVG_SPEED -> runSortedByAvgSpeed.value?.let { runs.value = it }
        SortType.CALORIES_BURNED -> runSortedByCaloriesBurned.value?.let { runs.value = it }
        SortType.DISTANCE -> runSortedByDistance.value?.let { runs.value = it }
    }.also {
        this.sortType = sortType
    }
    
    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }
}