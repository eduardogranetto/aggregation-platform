package com.aggregationplatform.aggregationdatawritter.service

import com.aggregationplatform.aggregationdatawritter.exception.NotFoundException
import com.aggregationplatform.aggregationdatawritter.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(
	private val eventRepository: EventRepository
) {
	
	fun get(name: String) = eventRepository.findByName(name) ?: throw NotFoundException
	
}