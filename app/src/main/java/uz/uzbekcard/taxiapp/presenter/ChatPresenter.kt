package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.ChatIntent
import uz.uzbekcard.taxiapp.ui.uistate.ChatUiState
import uz.uzbekcard.taxiapp.util.direction.ChatDirection

interface ChatPresenter {
    val uiState : StateFlow<ChatUiState>
    fun onEventDispatch(intent : ChatIntent)
}