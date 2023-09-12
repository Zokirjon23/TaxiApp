package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.domain.repository.Repository
import uz.uzbekcard.taxiapp.domain.repository.impl.RepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::RepositoryImpl) bind(Repository::class)
}