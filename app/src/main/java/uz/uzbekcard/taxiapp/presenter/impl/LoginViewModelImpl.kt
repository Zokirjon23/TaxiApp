package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.uzbekcard.taxiapp.presenter.LoginViewModel
import uz.uzbekcard.taxiapp.source.model.Message
import uz.uzbekcard.taxiapp.ui.intent.LoginIntent
import uz.uzbekcard.taxiapp.ui.uistate.LoginUiState

class LoginViewModelImpl : ScreenModel, LoginViewModel {
    override
    val uiState = MutableStateFlow(LoginUiState())

    override
    fun onEventDispatch(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Send -> {
                uiState.update { it.copy(loading = true) }
                coroutineScope.launch {
                    delay(3000)
                    uiState.update { it.copy(loading = false,message = Message(text = "No Server")) }
                }
            }

            is LoginIntent.DismissError -> {
                uiState.update { it.copy(message = null) }
            }
        }
    }
}