package org.example.project.data.networking.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createHttpClient(): HttpClient {
    return HttpClient(createPlatformHttpClient()) {
        install(Logging){
            this.logger = Logger.DEFAULT
            this.level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }
    }

}