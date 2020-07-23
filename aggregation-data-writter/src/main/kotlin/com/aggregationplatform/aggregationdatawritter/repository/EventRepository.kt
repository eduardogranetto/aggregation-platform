package com.aggregationplatform.aggregationdatawritter.repository

import com.aggregationplatform.aggregationdatawritter.model.Event
import org.springframework.stereotype.Repository

@Repository
class EventRepository {

	fun findByName(name: String) = try{
		Event.valueOf(name)
	}catch (e: IllegalArgumentException){
		null
	}

}