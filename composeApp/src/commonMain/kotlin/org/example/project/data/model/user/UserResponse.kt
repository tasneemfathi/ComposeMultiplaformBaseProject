package org.example.project.data.model.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("data")
    val user: List<User>,
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("support")
    val support: Support,
    @SerialName("total")
    val total: Int,
    @SerialName("total_pages")
    val totalPages: Int
)