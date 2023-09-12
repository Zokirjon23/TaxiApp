package uz.uzbekcard.taxiapp.di

import android.util.Log
import uz.uzbekcard.taxiapp.source.local.Storage
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.BuildConfig

val networkModule = module {
    single { provideClient(get()) }
}

private fun provideClient(storage : Storage) : HttpClient{
    return HttpClient(Android){
        install(ContentNegotiation) {
            json()
        }

        if (BuildConfig.DEBUG){
            install(Logging){
                level = LogLevel.ALL
            }
        }

        expectSuccess = true

        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, _ ->
                Log.d("NETWORK_ERROR", "network error:${exception.message} ")
            }
        }

        defaultRequest {
            url(BuildConfig.BASE_URL)
            if (!storage.token.isNullOrEmpty()) {
                header("Authentication", storage.token)
            }
        }
    }
}