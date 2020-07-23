package com.aggregationplatform.aggregationdatawritter.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.OffsetDateTime

@Document("aggregation-data")
data class AggregationData(
	@Id val key: String,
	val createdAt: OffsetDateTime = OffsetDateTime.now(),
	val count: Int = 0
)