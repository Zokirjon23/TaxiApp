package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uzbekcard.taxiapp.util.AppScreen
import uz.uzbekcard.taxiapp.util.component.BoxApp
import uz.uzbekcard.taxiapp.util.component.ColumnApp
import uz.uzbekcard.taxiapp.util.component.TextApp
import uz.uzbekcard.taxiapp.util.component.ToolbarApp

class SmsVerificationScreen : AppScreen {
    @Composable
    override fun Content() {
        SmsVerificationContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SmsVerificationContent() {
        val otp = remember { mutableStateOf("") }
        BoxApp(Modifier.fillMaxSize()) {
            ColumnApp {
                ToolbarApp(title = "Sms Verification")
                TextApp(
                    text = "Almost there ",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)
                )
                TextApp(
                    text = "Please enter the 6-digit code sent to your email +99893 123 45 67 for verification.",
                    fontSize = 14.sp, modifier = Modifier.padding(horizontal = 16.dp)
                )
                OutlinedTextField(value = otp.value, onValueChange = { otp.value = it })
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 16.dp, end = 16.dp)
                ) {
                    TextApp(
                        text = "VERIFY",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                    )
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun SmsVerificationPreview() {
        SmsVerificationContent()
    }
}