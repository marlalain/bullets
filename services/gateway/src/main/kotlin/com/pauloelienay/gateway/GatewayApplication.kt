package com.pauloelienay.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class DiscoveryApplication

fun main(args: Array<String>) {
	runApplication<DiscoveryApplication>(*args)
}