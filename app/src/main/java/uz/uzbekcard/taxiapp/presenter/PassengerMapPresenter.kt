package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.PassagerMapIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassagerMapUiState

interface PassengerMapPresenter {
    val uiState : StateFlow<PassagerMapUiState>
    fun onEventDispatch(intent: PassagerMapIntent)
}