package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.domain.usecase.SplashUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.domain.usecase.ChatUserUsesCase
import uz.uzbekcard.taxiapp.domain.usecase.ChatUsesCase
import uz.uzbekcard.taxiapp.domain.usecase.DirectionUsesCase
import uz.uzbekcard.taxiapp.domain.usecase.PassengerMapUsesCase
import uz.uzbekcard.taxiapp.domain.usecase.PassengerSettingUsesCase
import uz.uzbekcard.taxiapp.domain.usecase.impl.ChatUserUsesCaseImpl
import uz.uzbekcard.taxiapp.domain.usecase.impl.ChatUsesCaseImpl
import uz.uzbekcard.taxiapp.domain.usecase.impl.DirectionUsesCaseImpl
import uz.uzbekcard.taxiapp.domain.usecase.impl.PassengerMapUsesCaseImpl
import uz.uzbekcard.taxiapp.domain.usecase.impl.PassengerSettingUsesCaseImpl

val useCaseModule = module {
    /**
     * Passenger
     */
    factoryOf(::ChatUsesCaseImpl) bind(ChatUsesCase::class)
    factoryOf(::ChatUserUsesCaseImpl) bind(ChatUserUsesCase::class)
    factoryOf(::DirectionUsesCaseImpl) bind(DirectionUsesCase::class)
    factoryOf(::PassengerSettingUsesCaseImpl) bind(PassengerSettingUsesCase::class)
    factoryOf(::PassengerMapUsesCaseImpl) bind(PassengerMapUsesCase::class)
}