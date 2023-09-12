package uz.uzbekcard.taxiapp.presenter

import uz.uzbekcard.taxiapp.ui.intent.SplashIntent

interface SplashViewModel {
    fun onEventDispatch(splashIntent: SplashIntent)
}