package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.uzbekcard.taxiapp.domain.usecase.DirectionUsesCase
import uz.uzbekcard.taxiapp.presenter.DirectionPresenter
import uz.uzbekcard.taxiapp.ui.intent.DirectionIntent
import uz.uzbekcard.taxiapp.ui.uistate.DirectionUiState
import uz.uzbekcard.taxiapp.util.direction.DriftDirection

class DirectionPresenterImpl(
    private val direction: DriftDirection,
//    private val useCase: DirectionUsesCase
) : ScreenModel, DirectionPresenter {
    override val uiState = MutableStateFlow(DirectionUiState())

    override fun onEventDispatch(intent: DirectionIntent) {

    }
}