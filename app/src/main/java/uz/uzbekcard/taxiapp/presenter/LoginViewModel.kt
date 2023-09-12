package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.LoginIntent
import uz.uzbekcard.taxiapp.ui.uistate.LoginUiState

interface LoginViewModel {
    val uiState : StateFlow<LoginUiState>
    fun onEventDispatch(intent : LoginIntent)
}