package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.presenter.PassengerMapPresenter
import uz.uzbekcard.taxiapp.presenter.impl.PassengerMapPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.PassagerMapIntent
import uz.uzbekcard.taxiapp.ui.uistate.PassagerMapUiState
import uz.uzbekcard.taxiapp.util.component.BoxApp

class PassengerMapScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Map"
            val icon = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_map))

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        val viewModel : PassengerMapPresenter = getScreenModel<PassengerMapPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        PassengerMapContent(uiState,viewModel::onEventDispatch)
    }

    @Composable
    fun PassengerMapContent(
        uiState: State<PassagerMapUiState>,
        intent: (PassagerMapIntent) -> Unit
    ) {
//        val cameraState = rememberCameraPositionState()
//        BoxApp {
//            val marker = LatLng(41.0, 69.0)
//            GoogleMap(
//                modifier = Modifier.fillMaxSize(),
//                cameraPositionState = cameraState,
//                properties = MapProperties(
//                    isMyLocationEnabled = true,
//                    mapType = MapType.HYBRID,
//                    isTrafficEnabled = true
//                )
//            ) {
//                Marker(
//                    state = MarkerState(position = marker),
//                    title = "MyPosition",
//                    snippet = "This is a description of this Marker",
//                    draggable = true
//                )
//            }
//        }
    }

    @Preview
    @Composable
    fun MapPreview() {
        PassengerMapContent(remember {
            mutableStateOf(PassagerMapUiState())
        }){}
    }
}