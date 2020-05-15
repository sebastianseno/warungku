package com.seno.bukawarungtest.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun providesRoom(context: Context): BukaWarungDb {
        return Room.databaseBuilder(context, BukaWarungDb::class.java, "buka_warung.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}