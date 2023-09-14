package uz.uzbekcard.taxiapp.domain.repository.impl

import uz.uzbekcard.taxiapp.source.local.Storage
import uz.uzbekcard.taxiapp.domain.repository.AuthRepository
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val storage: Storage, private val api : HttpClient) : AuthRepository {

}