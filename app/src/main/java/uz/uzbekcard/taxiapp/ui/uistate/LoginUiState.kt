package uz.uzbekcard.taxiapp.ui.uistate

import uz.uzbekcard.taxiapp.source.model.Message

data class LoginUiState(val loading : Boolean = false,val message : Message? = null)
