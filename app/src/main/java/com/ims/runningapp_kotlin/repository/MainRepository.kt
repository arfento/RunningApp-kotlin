package com.ims.runningapp_kotlin.repository

import com.ims.runningapp_kotlin.db.Run
import com.ims.runningapp_kotlin.db.RunDao
import javax.inject.Inject

class MainRepository  @Inject constructor(
    val runDao: RunDao
) {

    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunSortedByDate() = runDao.getAllRunSortedByDate()

    fun getAllRunSortedByDistance() = runDao.getAllRunSortedBydistanceInMeters()

    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunSortedBytimeInMillis()

    fun getAllRunSortedByAvgSpeed() = runDao.getAllRunSortedByavgSpeedInKMH()

    fun getAllRunSortedByCaloriesBurned() = runDao.getAllRunSortedBycaloriesBurned()


    fun getTotalAvgSpeed() = runDao.getTotalavgSpeedInKMH()
    fun getTotalDistance() = runDao.getTotaldistanceInMeters()
    fun getTotalCaloriesBurned() = runDao.getTotalcaloriesBurned()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()




}