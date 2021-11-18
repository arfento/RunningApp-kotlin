package com.ims.runningapp_kotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run : Run)

    @Delete
    suspend fun deleteReun (run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunSortedBytimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunSortedBycaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunSortedByavgSpeedInKMH(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunSortedBydistanceInMeters(): LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) from running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) from running_table")
    fun getTotalcaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) from running_table")
    fun getTotaldistanceInMeters(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) from running_table")
    fun getTotalavgSpeedInKMH(): LiveData<Float>



}