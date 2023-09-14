package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.PassagerSettingIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassengerSettingUiState

interface PassengerSettingPresenter {
    val uiState : StateFlow<PassengerSettingUiState>
    fun onEventDispatch(intent : PassagerSettingIntent)
}