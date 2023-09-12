package uz.uzbekcard.taxiapp.domain.repository.impl

import uz.uzbekcard.taxiapp.source.local.Storage
import uz.uzbekcard.taxiapp.domain.repository.Repository
import io.ktor.client.HttpClient

class RepositoryImpl(private val storage: Storage, private val api : HttpClient) : Repository {

}