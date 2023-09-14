package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.uzbekcard.taxiapp.domain.usecase.ChatUsesCase
import uz.uzbekcard.taxiapp.presenter.ChatPresenter
import uz.uzbekcard.taxiapp.ui.intent.ChatIntent
import uz.uzbekcard.taxiapp.ui.uistate.ChatUiState
import uz.uzbekcard.taxiapp.util.direction.ChatDirection

class ChatPresenterImpl(private val direction: ChatDirection, private val usesCase: ChatUsesCase) :
    ScreenModel, ChatPresenter {
    override val uiState = MutableStateFlow(ChatUiState())

    override fun onEventDispatch(intent: ChatIntent) {

    }
}