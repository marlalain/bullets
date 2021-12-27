package com.pauloelienay.messages

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MessagesApplication

fun main(args: Array<String>) {
	runApplication<MessagesApplication>(*args)
}
