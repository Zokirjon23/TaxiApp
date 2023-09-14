package uz.uzbekcard.taxiapp.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.ui.theme.color_background
import uz.uzbekcard.taxiapp.ui.theme.error_color
import uz.uzbekcard.taxiapp.ui.theme.success_color
import uz.uzbekcard.taxiapp.util.component.IconApp
import uz.uzbekcard.taxiapp.util.component.TextApp
import kotlin.math.roundToInt

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToastApp(
    modifier: Modifier = Modifier,
    text: String = "Идентификация пройдена",
    iconId: Int = R.drawable.ic_done,
    color: Color = success_color,
    enter: EnterTransition = slideInVertically(
        initialOffsetY = { -40 }
    ) + expandVertically(
        expandFrom = Alignment.Top
    ) + scaleIn(
        transformOrigin = TransformOrigin(0.5f, 0f)
    ) + fadeIn(initialAlpha = 0.3f),
    exit: ExitTransition = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(
        targetScale = 1.2f
    ),
    onDismiss: () -> Unit
) {
    val isVisible = remember { mutableStateOf(false) }
    val offsetX = remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = Unit) {
        delay(10)
        isVisible.value = true
        delay(3000)
        isVisible.value = false
        onDismiss()
    }

    AnimatedVisibility(
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .offset { IntOffset(offsetX.value.roundToInt(), 0) }
            .pointerInput(Unit) {
                detectDragGestures { _, _ ->
                    isVisible.value = false
                }
            },
        visible = isVisible.value,
        exit = exit,
        enter = enter
    ) {
        Box(modifier = Modifier.background(color_background, RoundedCornerShape(10.dp))) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0x26C55D26))
                    .padding(horizontal = 22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconApp(id = iconId, tint = color)
                TextApp(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp),
                    color = success_color,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToastError(
    text: String,
    modifier: Modifier = Modifier,
    enter: EnterTransition = slideInVertically(
        initialOffsetY = { -40 }
    ) + expandVertically(
        expandFrom = Alignment.Top
    ) + scaleIn(
        transformOrigin = TransformOrigin(0.5f, 0f)
    ) + fadeIn(initialAlpha = 0.3f),
    exit: ExitTransition = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(
        targetScale = 1.2f
    ),
    onDismiss: () -> Unit
) {
    val isVisible = remember { mutableStateOf(false) }
    val offsetX = remember { mutableStateOf(0f) }

    LaunchedEffect(key1 = Unit) {
        delay(10)
        isVisible.value = true
        delay(3000)
        isVisible.value = false
        onDismiss()
    }

    AnimatedVisibility(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .offset { IntOffset(offsetX.value.roundToInt(), 0) }
            .pointerInput(Unit) {
                detectDragGestures { _, _ ->
                    isVisible.value = false
                }
            },
        visible = isVisible.value,
        exit = exit,
        enter = enter
    ) {
        Box(
            modifier = Modifier
                .background(color_background, RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 50.dp)
                    .background(error_color.copy(0.15f))
                    .padding(horizontal = 22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconApp(id = R.drawable.ic_warning, tint = error_color)
                TextApp(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp),
                    color = error_color,
                    fontSize = 15.sp
                )
            }
        }
    }
}