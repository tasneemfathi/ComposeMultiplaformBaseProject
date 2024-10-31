package org.example.project.data.networking.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun createPlatformHttpClient(): HttpClientEngine {
    return OkHttp.create()
}