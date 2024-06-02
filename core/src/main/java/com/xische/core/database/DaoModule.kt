package com.xische.core.database

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): EducationDatabase {
        return Room.databaseBuilder(application, EducationDatabase::class.java, "db").build()
    }

    @Provides
    @Singleton
    fun provideWordDao(database: EducationDatabase): UniversityDao {
        return database.universityDao()
    }
}