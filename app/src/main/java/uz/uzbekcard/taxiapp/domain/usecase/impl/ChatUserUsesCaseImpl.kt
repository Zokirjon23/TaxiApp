package uz.uzbekcard.taxiapp.domain.usecase.impl

import uz.uzbekcard.taxiapp.domain.repository.PassengerChatListRepository
import uz.uzbekcard.taxiapp.domain.usecase.ChatUserUsesCase

class ChatUserUsesCaseImpl(private val chatRepository : PassengerChatListRepository) : ChatUserUsesCase {
}