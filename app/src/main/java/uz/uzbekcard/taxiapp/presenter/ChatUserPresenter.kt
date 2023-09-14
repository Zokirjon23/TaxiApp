package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import uz.uzbekcard.taxiapp.ui.intent.ChatUserIntent
import uz.uzbekcard.taxiapp.ui.uistate.ChatUserUiState

interface ChatUserPresenter {
    val uiState: StateFlow<ChatUserUiState>
    fun onEventDispatch(intent : ChatUserIntent)
}