package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.DirectionIntent
import uz.uzbekcard.taxiapp.ui.uistate.DirectionUiState

interface DirectionPresenter {
    val uiState : StateFlow<DirectionUiState>
    fun onEventDispatch(intent : DirectionIntent)
}