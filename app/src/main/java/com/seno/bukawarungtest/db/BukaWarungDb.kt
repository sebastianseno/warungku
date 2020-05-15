package com.seno.bukawarungtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seno.bukawarungtest.db.dao.UserDao
import com.seno.bukawarungtest.db.entity.UserDb

@Database(
    entities = [UserDb::class],
    version = 1
)
abstract class BukaWarungDb : RoomDatabase() {
    abstract fun userDao(): UserDao


}