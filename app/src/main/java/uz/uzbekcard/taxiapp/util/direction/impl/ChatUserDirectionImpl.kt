package uz.uzbekcard.taxiapp.util.direction.impl

import uz.uzbekcard.taxiapp.ui.screen.ChatScreen
import uz.uzbekcard.taxiapp.util.direction.ChatUserDirection
import uz.uzbekcard.taxiapp.util.navigation.Navigation

class ChatUserDirectionImpl(private val navigation: Navigation) : ChatUserDirection {
    override suspend fun openChat() {
        navigation.navigateTo(ChatScreen())
    }
}