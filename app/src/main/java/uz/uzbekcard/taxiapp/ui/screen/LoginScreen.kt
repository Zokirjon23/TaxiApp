package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import kotlinx.coroutines.delay
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.presenter.LoginViewModel
import uz.uzbekcard.taxiapp.presenter.impl.LoginViewModelImpl
import uz.uzbekcard.taxiapp.ui.intent.LoginIntent
import uz.uzbekcard.taxiapp.ui.theme.poppins_medium
import uz.uzbekcard.taxiapp.ui.theme.color_primary
import uz.uzbekcard.taxiapp.ui.theme.text_color
import uz.uzbekcard.taxiapp.ui.uistate.LoginUiState
import uz.uzbekcard.taxiapp.util.AppScreen
import uz.uzbekcard.taxiapp.util.ToastError
import uz.uzbekcard.taxiapp.util.component.TextFieldPhoneApp
import uz.uzbekcard.taxiapp.util.component.BoxApp
import uz.uzbekcard.taxiapp.util.component.ColumnApp
import uz.uzbekcard.taxiapp.util.component.IconApp
import uz.uzbekcard.taxiapp.util.component.TextApp
import uz.uzbekcard.taxiapp.util.component.ToolbarApp
import uz.uzbekcard.taxiapp.util.extension.massageToText

class LoginScreen : AppScreen {

    @Composable
    override fun Content() {
        val viewModel: LoginViewModel = getScreenModel<LoginViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState()
        LoginContent(uiState, viewModel::onEventDispatch)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginContent(uiState: State<LoginUiState>, intent: (LoginIntent) -> Unit) {
        val phone = remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }

        LaunchedEffect(focusRequester) {
            focusRequester.requestFocus()
        }

        BoxApp(modifier = Modifier.fillMaxSize()) {
            ColumnApp {
                ToolbarApp(title = "Login")
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = text_color,
                                fontFamily = poppins_medium
                            )
                        ) {
                            append("Welcome \n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = color_primary,
                                fontFamily = poppins_medium
                            )
                        ) {
                            append("Login ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = text_color,
                                fontFamily = poppins_medium
                            )
                        ) {
                            append("Now !")
                        }
                    },
                    modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp),
                    lineHeight = 44.sp
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            ) {
                TextApp(
                    text = "Phone Number",
                    modifier = Modifier.padding(bottom = 11.dp)
                )
                TextFieldPhoneApp(
                    phone = phone.value,
                    onPhoneChanged = { if (!uiState.value.loading) phone.value = it },
                    modifier = Modifier.focusRequester(focusRequester)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 43.dp)
                        .width(171.dp)
                        .height(40.dp)
                        .background(
                            color = color_primary,
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .clickable {
                            intent(LoginIntent.Send(phone.value))
                        }

                ) {
                    if (!uiState.value.loading) {
                        TextApp(
                            text = "Sign In",
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            modifier = Modifier.align(Alignment.Center)
                        )
                        IconApp(
                            R.drawable.ic_arrow_left,
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 12.dp)
                        )
                    } else {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(30.dp), color = Color.White
                        )
                    }
                }
            }


            uiState.value.message?.let {
                ToastError(text = it.massageToText()) { intent(LoginIntent.DismissError) }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun LoginPreview() {
        LoginContent(remember{ mutableStateOf(LoginUiState()) }) {}
    }
}