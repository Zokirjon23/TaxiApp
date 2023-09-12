package uz.uzbekcard.taxiapp.util.navigation

import uz.uzbekcard.taxiapp.util.AppScreen

interface Navigation {
   suspend fun navigateTo(screen : AppScreen)
   suspend fun replace(screen: AppScreen)
   suspend fun back()
}