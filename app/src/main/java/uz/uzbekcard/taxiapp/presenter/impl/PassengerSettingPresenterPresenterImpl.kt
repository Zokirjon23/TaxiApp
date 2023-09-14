package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.uzbekcard.taxiapp.domain.usecase.PassengerSettingUsesCase
import uz.uzbekcard.taxiapp.presenter.PassengerSettingPresenter
import uz.uzbekcard.taxiapp.ui.intent.PassagerSettingIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassengerSettingUiState

class PassengerSettingPresenterPresenterImpl(
    private val usesCase : PassengerSettingUsesCase
) : ScreenModel, PassengerSettingPresenter {
    override val uiState = MutableStateFlow(PassengerSettingUiState())

    override fun onEventDispatch(intent: PassagerSettingIntent) {

    }
}