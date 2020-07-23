package com.aggregationplatform.aggregationdatawritter.controller

import com.aggregationplatform.aggregationdatawritter.repository.AggregationDataRepository
import com.aggregationplatform.aggregationdatawritter.service.AggregationDataService
import com.aggregationplatform.aggregationdatawritter.service.AggregationService
import com.aggregationplatform.aggregationdatawritter.service.EventDataService
import com.aggregationplatform.aggregationdatawritter.service.EventService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/v1/events/{eventName}/data")
class EventDataController(
	private val eventService: EventService,
	private val eventDataService: EventDataService,
	private val aggregationService: AggregationService,
	private val aggregationDataService: AggregationDataService,
	private val aggregationDataRepository: AggregationDataRepository
) {

	@GetMapping
	fun all() = ResponseEntity.ok(
		aggregationDataRepository.findAll()
	)
	
	@PostMapping
	fun create(@PathVariable eventName: String, @RequestBody eventData: Map<String, Any>) : ResponseEntity<*>{
		val event = eventService.get(eventName)
		val aggregations = aggregationService.all(event)
		val mappedEventData = eventDataService.parse(event, eventData)
		aggregationDataService.upsert(aggregations, mappedEventData)
		return ResponseEntity.ok(
			mapOf("status" to "OK")
		)
	}
	
}