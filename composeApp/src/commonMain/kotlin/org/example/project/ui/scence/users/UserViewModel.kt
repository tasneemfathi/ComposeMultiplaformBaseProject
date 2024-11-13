package org.example.project.ui.scence.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.data.datastore.repo.AppConfigRepo
import org.example.project.data.datastore.repo.ProfileRepo
import org.example.project.data.model.user.User
import org.example.project.data.networking.repo.UserRepo
import org.example.project.data.networking.utils.onError
import org.example.project.data.networking.utils.onSuccess


class UserViewModel(val userRepo: UserRepo,private val appConfigRepo: AppConfigRepo) : ViewModel(){
    private val _usersList = MutableStateFlow<List<User>>(listOf())
    val usersList = _usersList.asStateFlow()
    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading = _isLoading.asStateFlow()

    var currentUser : User? = null
    val appLang : Flow<String> = appConfigRepo.appLang

    init {
        fetchUsersList()
    }

    private fun fetchUsersList() {
        _isLoading.value = true
        viewModelScope.launch {
            userRepo.fetchUsersRepoDate().onSuccess {
                _isLoading.value = false
                _usersList.value = it.user
            }.onError {
                _isLoading.value = false
            }
        }
    }


    fun updateAppLang(lang:String){
        viewModelScope.launch {
            appConfigRepo.updateAppLang(lang)
        }
    }

}