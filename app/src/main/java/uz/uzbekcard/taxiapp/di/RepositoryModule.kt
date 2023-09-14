package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.domain.repository.AuthRepository
import uz.uzbekcard.taxiapp.domain.repository.impl.AuthRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.domain.repository.PassengerChatListRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerChatRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerMapRepository
import uz.uzbekcard.taxiapp.domain.repository.PassengerSettingRepository
import uz.uzbekcard.taxiapp.domain.repository.impl.PassengerChatRepositoryImpl

val authRepositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind (AuthRepository::class)
    singleOf(::PassengerChatRepositoryImpl) binds (arrayOf(
        PassengerChatRepository::class,
        PassengerChatListRepository::class,
        PassengerMapRepository::class,
        PassengerSettingRepository::class
    ))
}