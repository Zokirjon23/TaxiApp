package uz.uzbekcard.taxiapp.ui.intent

sealed interface LoginIntent{
    object
    DismissError : LoginIntent

    data class Send(val phone : String) : LoginIntent
}