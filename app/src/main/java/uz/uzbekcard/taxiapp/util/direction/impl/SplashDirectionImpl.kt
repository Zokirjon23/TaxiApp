package uz.uzbekcard.taxiapp.util.direction.impl

import uz.uzbekcard.taxiapp.ui.screen.PhoneVerificationScreen
import uz.uzbekcard.taxiapp.util.direction.SplashDirection
import uz.uzbekcard.taxiapp.util.navigation.Navigation

class SplashDirectionImpl constructor(private val navigation : Navigation) : SplashDirection {
   override suspend fun openRegistrationScreen(){
       navigation.navigateTo(PhoneVerificationScreen())
   }
}