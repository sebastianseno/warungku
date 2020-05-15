package com.seno.bukawarungtest.repo

import androidx.lifecycle.LiveData
import com.seno.bukawarungtest.db.BukaWarungDb
import com.seno.bukawarungtest.db.entity.UserDb
import com.seno.bukawarungtest.rest.UserServices
import com.seno.bukawarungtest.utils.ioThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(
    private val userServices: UserServices,
    private val warungDb: BukaWarungDb
) {

    private val userDao = warungDb.userDao()

    suspend fun refreshUser () {
        val response = userServices.getUsers()
        val userToDb = response.data.map { it.toDb() }
        insertToDb(userToDb)
//        warungDb.runInTransaction{
//            userDao.insertUser(userToDb)
//        }
    }

    fun getAllUser(): LiveData<List<UserDb>> {
        return userDao.getAllUser()
    }

    private fun insertToDb(data: List<UserDb>) {
        ioThread {
            userDao.insertUser(data)
        }
    }

    fun getUserById(id: Int): LiveData<UserDb> {
        return userDao.getUserbyId(id)
    }
}