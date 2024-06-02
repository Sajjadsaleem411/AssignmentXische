package com.xische.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xische.core.data.University

@Dao
interface UniversityDao {
    @Query("SELECT * FROM university")
    fun getUniversities(): List<University>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(universities: List<University>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUniversity(university: University)

    @Delete
    fun deleteAll(universities: List<University>)

}