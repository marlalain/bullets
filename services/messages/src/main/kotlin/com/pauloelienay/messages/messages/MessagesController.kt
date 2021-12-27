package com.pauloelienay.messages.messages

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class MessagesController {
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	fun send(message: String): String = message
}