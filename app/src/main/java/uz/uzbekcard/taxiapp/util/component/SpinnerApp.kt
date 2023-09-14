package uz.uzbekcard.taxiapp.util.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.uzbekcard.taxiapp.ui.theme.color_background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerApp(selectedOptionText : MutableState<String>, hint : String, onDismiss : () -> Unit, list: List<String>, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }, modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .menuAnchor(),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0x26000026),
                unfocusedBorderColor = Color(0x26000026),
            ),
            label = {
                TextApp(
                    text = hint,
                    color = Color(0xFF353535)
                )
            },
            readOnly = true,
            value = selectedOptionText.value,
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                onDismiss()
                expanded = false
            }, modifier = Modifier
                .fillMaxWidth()
                .background(color_background)
        ) {
            list.forEach { selectionOption ->
                DropdownMenuItem(text = { TextApp(text = selectionOption) }, onClick = {
                    selectedOptionText.value = selectionOption
                    expanded = false
                })
            }
        }
    }
}