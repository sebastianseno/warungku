package com.seno.bukawarungtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.seno.bukawarungtest.dagger.BaseViewModel
import com.seno.bukawarungtest.db.entity.UserDb
import com.seno.bukawarungtest.repo.UserRepo
import com.seno.bukawarungtest.utils.SingleLiveEvent
import com.seno.bukawarungtest.utils.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor (
    private val repo: UserRepo
): BaseViewModel() {

    val refreshUserState = SingleLiveEvent<UiState>()

    val getAllUser: LiveData<List<UserDb>>
        get() = repo.getAllUser()

    val selectedUserId = MutableLiveData<Int>()

    val getUserbyId = Transformations.switchMap(selectedUserId) {
        repo.getUserById(it)
    }

    fun setUserId(id: Int) {
        if (selectedUserId.value != id) {
            selectedUserId.value = id
        }
    }

    fun refreshAllUser() {
        viewModelScope.launch {
            refreshUserState.sendAction(UiState.Loading)
            try {
                repo.refreshUser()
                refreshUserState.sendAction(UiState.Success)
            } catch (error: Exception) {
                refreshUserState.sendAction(UiState.Error(error.message ?: "Something Went Wrong"))
            }
        }
    }


}