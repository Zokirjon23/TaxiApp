package uz.uzbekcard.taxiapp.domain.usecase.impl

import uz.uzbekcard.taxiapp.domain.repository.PassengerChatRepository
import uz.uzbekcard.taxiapp.domain.usecase.ChatUsesCase

class ChatUsesCaseImpl(private val chatRepository: PassengerChatRepository) : ChatUsesCase {
}