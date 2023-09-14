package uz.uzbekcard.taxiapp.domain.repository.impl

import io.ktor.client.HttpClient
import uz.uzbekcard.taxiapp.domain.repository.PassengerChatListRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerChatRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerMapRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerSettingRepository
import uz.uzbekcard.taxiapp.source.local.Storage

class PassengerChatRepositoryImpl(private val storage: Storage, private val api: HttpClient) :
    PassengerChatRepository, PassengerChatListRepository, PassengerMapRepository,
    PassengerSettingRepository {
}