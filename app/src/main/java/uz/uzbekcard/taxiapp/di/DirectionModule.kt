package uz.uzbekcard.taxiapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.util.direction.SplashDirection
import uz.uzbekcard.taxiapp.util.direction.impl.SplashDirectionImpl

val directionModule = module {
    factoryOf(::SplashDirectionImpl) bind(SplashDirection::class)
}