package org.example.project.scence.add

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.example.project.data.datastore.repo.ProfileRepo
import org.example.project.data.model.profile.Profile
import org.example.project.utils.decodeBase64ToImageBitmap

class AddNewViewModel(val profileRepo: ProfileRepo):ViewModel(){
    val name = MutableStateFlow<String>("")
    val email = MutableStateFlow<String>("")
    val bio = MutableStateFlow<String>("")
    val avatar = MutableStateFlow<String>("")

    val image = MutableStateFlow<ImageBitmap?>(null)

    init {
        getLocalProfileData()
    }

    private fun getLocalProfileData(){
        viewModelScope.launch {
            profileRepo.userProfile.collectLatest {
                name.value = it.name
                email.value = it.email
                avatar.value = it.avatar
                bio.value = it.bio
                if(avatar.value.isNotBlank())
                    decodeBitmap()
            }
        }
    }

    fun updateProfile(){
        viewModelScope.launch {
            profileRepo.updateUserProfile(Profile(name = name.value, email= email.value, avatar = avatar.value, bio = bio.value))
        }
    }

    private fun decodeBitmap(){
        CoroutineScope(Dispatchers.IO).launch {
            val decodedImage = decodeBase64ToImageBitmap(avatar.value)

            // Switching back to Main thread to return the result
            withContext(Dispatchers.Main) {
                image.value = decodedImage
            }
        }
    }

}