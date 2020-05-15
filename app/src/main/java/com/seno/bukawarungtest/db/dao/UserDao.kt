package com.seno.bukawarungtest.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.seno.bukawarungtest.db.entity.UserDb

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(data: List<UserDb>)

    @Query("SELECT * FROM UserDb")
    fun getAllUser(): LiveData<List<UserDb>>

    @Query("SELECT * FROM UserDb WHERE id = :userId")
    fun getUserbyId(userId: Int): LiveData<UserDb>

    @Transaction
    fun insertUserTransaction(data: List<UserDb>) {
        insertUser(data)
    }
}