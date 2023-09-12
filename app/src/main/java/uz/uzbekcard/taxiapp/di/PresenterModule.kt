package uz.uzbekcard.taxiapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import uz.uzbekcard.taxiapp.presenter.impl.SplashViewModelImpl
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.presenter.LoginViewModel
import uz.uzbekcard.taxiapp.presenter.SplashViewModel
import uz.uzbekcard.taxiapp.presenter.impl.LoginViewModelImpl

val presenterModule = module {
    factoryOf(::SplashViewModelImpl) bind(SplashViewModel::class)
    factoryOf(::LoginViewModelImpl) bind (LoginViewModel::class)
}