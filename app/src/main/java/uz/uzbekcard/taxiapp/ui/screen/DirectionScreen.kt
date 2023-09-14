package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.presenter.DirectionPresenter
import uz.uzbekcard.taxiapp.presenter.impl.DirectionPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.DirectionIntent
import uz.uzbekcard.taxiapp.ui.theme.color_primary
import uz.uzbekcard.taxiapp.ui.uistate.DirectionUiState
import uz.uzbekcard.taxiapp.util.component.BoxApp
import uz.uzbekcard.taxiapp.util.component.ColumnApp
import uz.uzbekcard.taxiapp.util.component.IconApp
import uz.uzbekcard.taxiapp.util.component.SpinnerApp
import uz.uzbekcard.taxiapp.util.component.TextApp
import uz.uzbekcard.taxiapp.util.component.ToolbarApp

class DirectionScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Direction"
            val icon =
                rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_direction))

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
        val viewModel: DirectionPresenter = getScreenModel<DirectionPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        DirectionContent(uiState, viewModel::onEventDispatch)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DirectionContent(uiState: State<DirectionUiState>, intent: (DirectionIntent) -> Unit) {
        val region = remember { mutableStateOf("") }

        BoxApp(modifier = Modifier.fillMaxSize()) {
            ToolbarApp(title = "Yo'nalish tanlang", navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    IconApp(id = R.drawable.ic_back, tint = Color.White)
                }
            })
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    TextApp(text = "Viloyat")
                    SpinnerApp(
                        selectedOptionText = region,
                        hint = "Viloyat tanlang",
                        onDismiss = { },
                        list = listOf()
                    )
                    TextApp(text = "Tuman", modifier = Modifier.padding(top = 10.dp))
                    SpinnerApp(
                        selectedOptionText = region,
                        hint = "Tuman tanlang",
                        onDismiss = { },
                        list = listOf()
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally), shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(color_primary)
                    ) {
                        TextApp(text = "Tanlash", color = Color.White)
                    }
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun DirectionPreview() {
        DirectionContent(remember {
            mutableStateOf(DirectionUiState())
        }) {}
    }
}