package org.example.project.data.model.profile

import kotlinx.serialization.Serializable


@Serializable
data class Profile(val name:String = "", val email:String = "",val avatar:String = "",val bio:String = "")
