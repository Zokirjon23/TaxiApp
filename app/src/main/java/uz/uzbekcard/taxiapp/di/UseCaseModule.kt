package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.domain.usecase.SplashUseCase
import uz.uzbekcard.taxiapp.domain.usecase.impl.SplashUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::SplashUseCaseImpl) bind(SplashUseCase::class)
}