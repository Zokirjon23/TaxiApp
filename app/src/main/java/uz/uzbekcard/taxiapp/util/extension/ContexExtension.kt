package uz.uzbekcard.taxiapp.util.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.uzbekcard.taxiapp.source.model.Message


@Composable
fun Message.massageToText() : String{
    return text ?: stringResource(id!!)
}