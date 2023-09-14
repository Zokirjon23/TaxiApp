package uz.uzbekcard.taxiapp.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.ui.theme.color_primary

@Composable
fun AuthButton(modifier: Modifier = Modifier,onClick : () -> Unit,text : String,loadingState : Boolean) {
    Box(
        modifier = modifier
            .height(40.dp)
            .background(
                color = color_primary,
                shape = RoundedCornerShape(size = 5.dp)
            )
            .clickable {
                onClick()
            }

    ) {
        if (!loadingState) {
            TextApp(
                text = text,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                modifier = Modifier.align(Alignment.Center), fontSize = 16.sp
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
                    .size(30.dp), color = Color.White, strokeWidth = 2.dp
            )
        }
    }
}