package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.koin.getScreenModel
import uz.uzbekcard.taxiapp.presenter.ChatPresenter
import uz.uzbekcard.taxiapp.presenter.impl.ChatPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.ChatIntent
import uz.uzbekcard.taxiapp.ui.uistate.ChatUiState
import uz.uzbekcard.taxiapp.util.AppScreen

class ChatScreen : AppScreen {
    @Composable
    override fun Content() {
        val viewModel: ChatPresenter = getScreenModel<ChatPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        ChatScreenContent(uiState, viewModel::onEventDispatch)
    }

    @Composable
    fun ChatScreenContent(uiState: State<ChatUiState>, intent: (ChatIntent) -> Unit) {

    }

    @Preview
    @Composable
    fun ChatScreenPreview() {
        ChatScreenContent(uiState = remember {
            mutableStateOf(ChatUiState())
        }) {}
    }
}