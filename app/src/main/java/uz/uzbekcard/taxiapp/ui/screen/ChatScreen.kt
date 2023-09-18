package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.presenter.ChatPresenter
import uz.uzbekcard.taxiapp.presenter.impl.ChatPresenterImpl
import uz.uzbekcard.taxiapp.ui.intent.ChatIntent
import uz.uzbekcard.taxiapp.ui.theme.color_primary
import uz.uzbekcard.taxiapp.ui.uistate.ChatUiState
import uz.uzbekcard.taxiapp.util.AppScreen
import uz.uzbekcard.taxiapp.util.component.BoxApp
import uz.uzbekcard.taxiapp.util.component.IconApp
import uz.uzbekcard.taxiapp.util.component.TextApp

class ChatScreen : AppScreen {


    @Composable
    override fun Content() {
        val viewModel: ChatPresenter = getScreenModel<ChatPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        ChatScreenContent(uiState, viewModel::onEventDispatch)
    }

    @Composable
    fun ChatScreenContent(uiState: State<ChatUiState>, intent: (ChatIntent) -> Unit) {
        val avatar = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg")
                .build()
        )
        BoxApp(Modifier.background(color_primary)) {
            Column {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { }) {
                        IconApp(id = R.drawable.ic_back)
                    }
                    Image(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .shadow(elevation = 2.dp, shape = RoundedCornerShape(50))
                            .width(55.dp)
                            .height(55.dp)
                            .background(color = Color(0xFF91F495), RoundedCornerShape(50)),
                        painter = avatar,
                        contentDescription = null,
                    )
                    Column(Modifier.weight(0.5f)) {
                        TextApp(
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            text = "Charles Murfysdfdsfdsfdsfds",
                            fontSize = 20.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            modifier = Modifier.padding(top = 4.dp, end = 4.dp)
                        )

                        TextApp(
                            text = "online",
                            fontSize = 19.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        IconApp(id = R.drawable.ic_phone)
                    }
                }

                Box(Modifier.fillMaxSize()) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(bottom = 90.dp)
                            .background(
                                Color.White,
                                RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                            )
                    ) {}

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val s = remember {
                            mutableStateOf("")
                        }
                        TextField(value = s.value, onValueChange = { s.value = it }, modifier = Modifier.weight(0.7f), textStyle = TextStyle(fontSize = 18.sp))
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .clickable { }
                            .padding(8.dp)) {
                            IconApp(id = R.drawable.ic_send)
                        }
                    }
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun ChatScreenPreview() {
        ChatScreenContent(uiState = remember {
            mutableStateOf(ChatUiState())
        }) {}
    }
}