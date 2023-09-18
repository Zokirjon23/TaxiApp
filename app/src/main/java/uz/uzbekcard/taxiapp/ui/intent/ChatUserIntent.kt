package uz.uzbekcard.taxiapp.ui.intent

sealed interface ChatUserIntent{
    data class OpenChat(val unit : Unit = Unit) : ChatUserIntent
}