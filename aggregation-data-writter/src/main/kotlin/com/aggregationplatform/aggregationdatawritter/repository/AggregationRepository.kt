package com.aggregationplatform.aggregationdatawritter.repository

import com.aggregationplatform.aggregationdatawritter.model.Aggregation
import com.aggregationplatform.aggregationdatawritter.model.Event
import org.springframework.stereotype.Repository

@Repository
class AggregationRepository {
	
	fun findByEvent(event: Event) = Aggregation.values().filter { it.event == event }
	
}