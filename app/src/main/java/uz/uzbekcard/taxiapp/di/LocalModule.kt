package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.source.local.Storage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val storageModule = module {
    singleOf(::Storage)
}