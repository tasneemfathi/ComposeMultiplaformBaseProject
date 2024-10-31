package org.example.project.data.networking.repo

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.example.project.data.model.user.UserResponse
import org.example.project.data.networking.utils.NetworkingError
import org.example.project.data.networking.utils.Result
import org.example.project.utils.Constants

class UserRepo (private val httpClient: HttpClient){
    suspend fun fetchUsersRepoDate(): Result<UserResponse, NetworkingError> {
        val response = try{
            httpClient.get(Constants.GET_BASE_URL+"users/")
        } catch(e: UnresolvedAddressException) {
            return Result.Failure(NetworkingError.NO_INTERNET)
        } catch(e: SerializationException) {
            return Result.Failure(NetworkingError.SERIALIZATION)
        }
        return when(response.status.value){
            in 200..299 -> Result.Success(response.body<UserResponse>())
            401 -> Result.Failure(NetworkingError.UNAUTHORIZED)
            409 -> Result.Failure(NetworkingError.CONFLICT)
            408 -> Result.Failure(NetworkingError.REQUEST_TIMEOUT)
            413 -> Result.Failure(NetworkingError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Failure(NetworkingError.SERVER_ERROR)
            else -> Result.Failure(NetworkingError.UNKNOWN)
        }
    }
}