package uz.uzbekcard.taxiapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.util.direction.ChatDirection
import uz.uzbekcard.taxiapp.util.direction.ChatUserDirection
import uz.uzbekcard.taxiapp.util.direction.DriftDirection
import uz.uzbekcard.taxiapp.util.direction.MapDirection
import uz.uzbekcard.taxiapp.util.direction.SplashDirection
import uz.uzbekcard.taxiapp.util.direction.impl.ChatDirectionImpl
import uz.uzbekcard.taxiapp.util.direction.impl.ChatUserDirectionImpl
import uz.uzbekcard.taxiapp.util.direction.impl.DriftDirectionImpl
import uz.uzbekcard.taxiapp.util.direction.impl.MapDirectionImpl
import uz.uzbekcard.taxiapp.util.direction.impl.SplashDirectionImpl

val directionModule = module {
    factoryOf(::SplashDirectionImpl) bind(SplashDirection::class)
    factoryOf(::ChatDirectionImpl) bind(ChatDirection::class)
    factoryOf(::ChatUserDirectionImpl) bind(ChatUserDirection::class)
    factoryOf(::DriftDirectionImpl) bind(DriftDirection::class)
    factoryOf(::MapDirectionImpl) bind(MapDirection::class)
}