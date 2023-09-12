package uz.uzbekcard.taxiapp.di

import uz.uzbekcard.taxiapp.util.navigation.NavigationDispatcher
import uz.uzbekcard.taxiapp.util.navigation.NavigationImpl
import uz.uzbekcard.taxiapp.util.navigation.Navigation
import org.koin.dsl.binds
import org.koin.dsl.module

val navigationModule = module {
    single { NavigationImpl() } binds arrayOf(Navigation::class, NavigationDispatcher::class)
}