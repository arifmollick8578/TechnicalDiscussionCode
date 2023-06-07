package com.mollick.interviewproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mollick.interviewproject.data.User
import com.mollick.interviewproject.data.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.launch

class UserViewModel(application: Application): ViewModel() {
    // Can replace it by viewModelScope
    val scope = CoroutineScope(coroutineContext)

    // Can Inject it by Hilt
    private val repository: UserRepository
    val userInfo: LiveData<List<User>>

    init {
        val userDao = UserDatabase.getDatabase(application).getDao()
        repository = UserRepository(userDao)
        userInfo = repository.allUsers
    }

    fun insert(user: User) = scope.launch {
        repository.insert(user)
    }
}