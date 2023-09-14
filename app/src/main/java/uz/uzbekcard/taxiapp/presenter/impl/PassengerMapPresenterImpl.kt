package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.uzbekcard.taxiapp.domain.usecase.PassengerMapUsesCase
import uz.uzbekcard.taxiapp.presenter.PassengerMapPresenter
import uz.uzbekcard.taxiapp.ui.intent.PassagerMapIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassagerMapUiState

class PassengerMapPresenterImpl(
    private val direction: PassengerMapUsesCase,
    private val usesCase: PassengerMapUsesCase
) : ScreenModel, PassengerMapPresenter {
    override val uiState = MutableStateFlow(PassagerMapUiState())

    override fun onEventDispatch(intent: PassagerMapIntent) {

    }
}