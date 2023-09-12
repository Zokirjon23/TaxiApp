package uz.uzbekcard.taxiapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import uz.uzbekcard.taxiapp.presenter.impl.SplashViewModelImpl
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.presenter.SplashViewModel

val presenterModule = module {
//    viewModelOf(::SplashViewModelImpl) bind SplashViewModel::class
//    factory { SplashViewModelImpl(get()) }
    factoryOf(::SplashViewModelImpl) bind(SplashViewModel::class)
}