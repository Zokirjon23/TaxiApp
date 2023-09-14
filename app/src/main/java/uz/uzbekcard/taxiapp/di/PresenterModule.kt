package uz.uzbekcard.taxiapp.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import uz.uzbekcard.taxiapp.presenter.impl.SplashViewModelImpl
import org.koin.dsl.module
import uz.uzbekcard.taxiapp.presenter.ChatPresenter
import uz.uzbekcard.taxiapp.presenter.ChatUserPresenter
import uz.uzbekcard.taxiapp.presenter.DirectionPresenter
import uz.uzbekcard.taxiapp.presenter.LoginViewModel
import uz.uzbekcard.taxiapp.presenter.PassengerMapPresenter
import uz.uzbekcard.taxiapp.presenter.PassengerSettingPresenter
import uz.uzbekcard.taxiapp.presenter.SplashViewModel
import uz.uzbekcard.taxiapp.presenter.impl.ChatPresenterImpl
import uz.uzbekcard.taxiapp.presenter.impl.ChatUserPresenterImpl
import uz.uzbekcard.taxiapp.presenter.impl.DirectionPresenterImpl
import uz.uzbekcard.taxiapp.presenter.impl.LoginViewModelImpl
import uz.uzbekcard.taxiapp.presenter.impl.PassengerMapPresenterImpl
import uz.uzbekcard.taxiapp.presenter.impl.PassengerSettingPresenterPresenterImpl

val presenterModule = module {
    /**
     * Common
     */
    factoryOf(::SplashViewModelImpl) bind(SplashViewModel::class)
    factoryOf(::LoginViewModelImpl) bind (LoginViewModel::class)

    /**
     * Passenger
     */
    factoryOf(::ChatPresenterImpl) bind(ChatPresenter::class)
    factoryOf(::ChatUserPresenterImpl) bind(ChatUserPresenter::class)
    factoryOf(::DirectionPresenterImpl) bind(DirectionPresenter::class)
    factoryOf(::PassengerSettingPresenterPresenterImpl) bind(PassengerSettingPresenter::class)
    factoryOf(::PassengerMapPresenterImpl) bind(PassengerMapPresenter::class)
}