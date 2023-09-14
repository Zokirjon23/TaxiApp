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
import uz.uzbekcard.taxiapp.presenter.DirectionPresenter
import uz.uzbekcard.taxiapp.presenter.impl.DirectionPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.DirectionIntent
import uz.uzbekcard.taxiapp.ui.uistate.DirectionUiState

class DirectionScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Direction"
            val icon = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_direction))

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
        val viewModel : DirectionPresenter = getScreenModel<DirectionPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        DirectionContent(uiState,viewModel::onEventDispatch)
    }


    @Composable
    fun DirectionContent(uiState: State<DirectionUiState>, intent: (DirectionIntent) -> Unit) {

    }

    @Preview
    @Composable
    fun DirectionPreview() {
        DirectionContent(remember {
            mutableStateOf(DirectionUiState())
        }){}
    }
}