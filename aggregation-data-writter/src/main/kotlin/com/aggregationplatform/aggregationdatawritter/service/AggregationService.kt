package com.aggregationplatform.aggregationdatawritter.service

import com.aggregationplatform.aggregationdatawritter.model.Aggregation
import com.aggregationplatform.aggregationdatawritter.model.Event
import com.aggregationplatform.aggregationdatawritter.repository.AggregationRepository
import org.springframework.stereotype.Service

@Service
class AggregationService(
	private val aggregationRepository: AggregationRepository
) {
	
	fun all(event: Event) = aggregationRepository.findByEvent(event)
	
}

