package com.mollick.interviewproject

import androidx.lifecycle.LiveData
import com.mollick.interviewproject.data.User
import com.mollick.interviewproject.data.UserDao

class UserRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    // Can be suspend function
    fun insert(user: User) {
        userDao.insertUser(user)
    }
}