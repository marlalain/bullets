package com.pauloelienay.messages.sockets

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {
	@Value("\${spring.rabbitmq.username}")
	private lateinit var username: String

	@Value("\${spring.rabbitmq.password}")
	private lateinit var password: String

	@Value("\${spring.rabbitmq.host}")
	private lateinit var host: String

	@Value("\${spring.rabbitmq.port}")
	private lateinit var port: String

	val relay = arrayOf("/topic/", "/queue/", "/exchange/")

	override fun configureMessageBroker(registry: MessageBrokerRegistry) {
		registry
			.enableStompBrokerRelay(*relay)
			.setClientLogin(username)
			.setClientPasscode(password)
			.setRelayHost(host)
			.setRelayPort(port.toInt())
	}

	override fun registerStompEndpoints(registry: StompEndpointRegistry) {
		registry.addEndpoint("/ws")
			.setAllowedOrigins("*")
			.withSockJS()
	}
}