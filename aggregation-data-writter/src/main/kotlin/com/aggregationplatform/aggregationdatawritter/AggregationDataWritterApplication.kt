package com.aggregationplatform.aggregationdatawritter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class AggregationDataWritterApplication

fun main(args: Array<String>) {
	runApplication<AggregationDataWritterApplication>(*args)
}
