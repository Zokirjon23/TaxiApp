package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import uz.uzbekcard.taxiapp.presenter.SplashViewModel
import uz.uzbekcard.taxiapp.util.navigation.Navigation
import kotlinx.coroutines.launch
import uz.uzbekcard.taxiapp.ui.intent.SplashIntent
import uz.uzbekcard.taxiapp.util.direction.SplashDirection

class SplashViewModelImpl(
    private val direction: SplashDirection
) : SplashViewModel, ScreenModel {

    override fun onEventDispatch(splashIntent: SplashIntent) {
        when(splashIntent){
            is SplashIntent.OpenScreen -> coroutineScope.launch {
                direction.openRegistrationScreen()
            }
        }
    }
}