package uz.uzbekcard.taxiapp.ui.uistate

import uz.uzbekcard.taxiapp.source.model.Message

data class SmsVerificationUiState(val loading : Boolean = true,val message: Message? = null)