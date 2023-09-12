package uz.uzbekcard.taxiapp.source.model

import androidx.annotation.StringRes

data class Message(
    @StringRes val id : Int? = null,
    val text : String? = null
)