package com.pauloelienay.messages.message

import com.pauloelienay.messages.user.User

data class Message(
	val sender: User,
	val content: String
)