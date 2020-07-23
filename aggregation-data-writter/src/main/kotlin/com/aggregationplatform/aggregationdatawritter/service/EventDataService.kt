package com.aggregationplatform.aggregationdatawritter.service

import com.aggregationplatform.aggregationdatawritter.exception.NotFoundException
import com.aggregationplatform.aggregationdatawritter.model.Event
import org.springframework.stereotype.Service

@Service
class EventDataService {
	
	fun parse(event: Event, eventData: Map<String, Any>) = event.fields.map {
		Pair(it.name, eventData[it.path] ?: throw NotFoundException)
	}.toMap()
	
}