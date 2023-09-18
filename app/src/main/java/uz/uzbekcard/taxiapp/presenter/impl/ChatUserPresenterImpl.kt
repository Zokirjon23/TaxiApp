package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.uzbekcard.taxiapp.domain.usecase.ChatUserUsesCase
import uz.uzbekcard.taxiapp.presenter.ChatUserPresenter
import uz.uzbekcard.taxiapp.ui.intent.ChatUserIntent
import uz.uzbekcard.taxiapp.ui.uistate.ChatUserUiState
import uz.uzbekcard.taxiapp.util.direction.ChatUserDirection

class ChatUserPresenterImpl(
    private val direction: ChatUserDirection,
    private val usesCase: ChatUserUsesCase
) : ScreenModel, ChatUserPresenter {
    override val uiState = MutableStateFlow(ChatUserUiState())
    override fun onEventDispatch(intent: ChatUserIntent) {
        when(intent){
            is ChatUserIntent.OpenChat -> coroutineScope.launch {
                direction.openChat()
            }
        }
    }
}