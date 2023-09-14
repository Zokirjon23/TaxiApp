package uz.uzbekcard.taxiapp.util.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.ui.theme.color_primary
import uz.uzbekcard.taxiapp.ui.theme.color_secondary
import uz.uzbekcard.taxiapp.ui.theme.text_color


@Composable
fun TextFieldApp(
    modifier: Modifier = Modifier,
    state: MutableState<String>,
    hint: String,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text
    ),
    length: Int = Int.MAX_VALUE,
) {
    OutlinedTextField(
        value = state.value,
        onValueChange = { if (length >= it.length) state.value = it },
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color_secondary.copy(0.5f),
            unfocusedBorderColor = Color(0x26000026),
            focusedLabelColor = color_secondary
        ),
        label = { TextApp(text = hint, color = text_color.copy(0.5f)) }, singleLine = singleLine,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun DescriptionTextFieldApp(
    modifier: Modifier = Modifier,
    state: MutableState<String>,
    hint: String,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text
    ),
    length: Int = Int.MAX_VALUE,
    description: String? = null,
    descriptionColor: Color = text_color.copy(0.5f),
    error: Boolean = false,
) {
    Column(modifier) {
        OutlinedTextField(
            value = state.value,
            onValueChange = { if (length >= it.length) state.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (error) color_primary else color_secondary.copy(0.5f),
                unfocusedBorderColor = if (error) color_primary else Color(0x26000026),
                focusedLabelColor = if (error) color_primary else color_secondary
            ),
            label = { TextApp(text = hint, color = text_color.copy(0.5f)) },
            singleLine = singleLine,
            keyboardOptions = keyboardOptions
        )
        description?.let {
            TextApp(
                text = it,
                fontSize = 12.sp,
                color = if (error) color_primary else descriptionColor,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400), modifier = Modifier.padding(top = 4.dp, start = 15.dp)
            )
        }
    }
}

@Composable
fun TextFieldPhoneApp(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = "+(998) 00 000 00 00",
    maskNumber: Char = '0',
    imeAction: ImeAction = ImeAction.Next,
    onPhoneChanged: (String) -> Unit,
) {
    OutlinedTextField(
        value = phone,
        onValueChange = { it ->
            onPhoneChanged(it.take(mask.count { it == maskNumber }))
        },
//        label = {
//            Text(
//                text = stringResource(
//                    id = R.string.phone_number
//                ), color = text_color.copy(0.5f)
//            )
//        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0x26000026),
            unfocusedBorderColor = Color(0x26000026),
            focusedLabelColor = color_secondary
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = imeAction
        ),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        placeholder = {
            Text(
                text = stringResource(
                    id = R.string.enter_phone_number
                ), color = text_color.copy(0.5f)
            )
        }
    )
}

class PhoneVisualTransformation(private val mask: String, private val maskNumber: Char) :
    VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}

@Composable
fun TextFieldPasswordApp(
    modifier: Modifier = Modifier,
    state: MutableState<String>,
    hint: String = stringResource(R.string.password),
    isError: State<String> = remember {
        mutableStateOf("")
    },
    isErrorColor: Color = Color.Red,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            value = state.value,
            onValueChange = { state.value = it },
            label = { TextApp(hint, color = text_color.copy(0.5f)) },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.ic_password_showon)
                else painterResource(id = R.drawable.ic_password_hide)

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, description, tint = Color(0xFF460000))
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color_secondary.copy(alpha = 0.5f),
                unfocusedBorderColor = Color(0x26000026),
                focusedLabelColor = color_secondary
            ),
        )
        if (isError.value.isNotEmpty()) TextApp(
            text = isError.value,
            color = isErrorColor,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 5.dp, start = 5.dp)
        )
    }
}

@Composable
fun RegistrationCodeInput(
    modifier: Modifier = Modifier,
    codeLength: Int,
    initialCode: String,
    onTextChanged: (String) -> Unit,
) {
    val code = remember(initialCode) {
        mutableStateOf(TextFieldValue(initialCode, TextRange(initialCode.length)))
    }
    val focusRequester = FocusRequester()
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        BasicTextField(
            value = code.value,
            onValueChange = { onTextChanged(it.text) },
            modifier = Modifier.focusRequester(focusRequester = focusRequester),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Number
            ),
            decorationBox = {
                CodeInputDecoration(code.value.text, codeLength)
            }
        )
    }
}

@Composable
private fun CodeInputDecoration(code: String, length: Int) {
    Box(modifier = Modifier) {
        Row(horizontalArrangement = Arrangement.Center) {
            for (i in 0 until length) {
                val text = if (i < code.length) code[i].toString() else ""
                CodeEntry(text)
            }
        }
    }
}

@Composable
private fun CodeEntry(text: String) {
    val color = animateColorAsState(
        targetValue = if (text.isEmpty()) Color.Gray.copy(alpha = .8f)
        else Color(0xFF460000).copy(.8f), label = ""
    )
    Box(
        modifier = Modifier
            .padding(4.dp)
            .width(80.dp)
            .height(55.dp)
            .border(width = 1.dp, color = color.value, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 6.dp, end = 6.dp, bottom = 8.dp)
                .height(2.dp)
                .fillMaxWidth()
            //.background(color.value, shape = RoundedCornerShape(10.dp))

        )
    }
}

@Preview
@Composable
fun TextFPreview() {
    Surface(color = Color.White) {
//        TextFieldApp(modifier = Modifier, state = remember {
//            mutableStateOf("")
//        }, hint = "login")
//        TextFieldPasswordApp(state = remember {
//            mutableStateOf("")
//        })
    }
}

