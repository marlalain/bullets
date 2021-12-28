package com.pauloelienay.messages.message

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class MessageController(
	private val template: SimpMessagingTemplate
) {
	@MessageMapping("/ws")
	fun message(message: Message) {
		template.convertAndSend("/topic/messages", message)
	}
}