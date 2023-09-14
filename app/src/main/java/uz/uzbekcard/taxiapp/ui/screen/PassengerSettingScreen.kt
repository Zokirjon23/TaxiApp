package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.presenter.PassengerSettingPresenter
import uz.uzbekcard.taxiapp.presenter.impl.PassengerSettingPresenterPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.PassagerSettingIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassengerSettingUiState

class PassengerSettingScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.enter_phone_number)
            val icon = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_arrow_left))

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        val viewModel : PassengerSettingPresenter = getScreenModel<PassengerSettingPresenterPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        PassengerSettingContent(uiState,viewModel::onEventDispatch)
    }

    @Composable
    fun PassengerSettingContent(
        uiState: State<PassengerSettingUiState>,
        intent: (PassagerSettingIntent) -> Unit
    ) {

    }

    @Preview
    @Composable
    fun PassengerSettingPreview() {
        PassengerSettingContent(remember {
            mutableStateOf(PassengerSettingUiState())
        }){}
    }
}