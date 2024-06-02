package com.xische.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xische.core.data.University

@Database(entities = [University::class], version = 1)
@TypeConverters(Converters::class)
abstract class EducationDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}