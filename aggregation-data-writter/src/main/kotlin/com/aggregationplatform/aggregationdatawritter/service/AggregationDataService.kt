package com.aggregationplatform.aggregationdatawritter.service

import com.aggregationplatform.aggregationdatawritter.model.Aggregation
import com.aggregationplatform.aggregationdatawritter.model.AggregationData
import com.aggregationplatform.aggregationdatawritter.repository.AggregationDataRepository
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.RuntimeException

@Service
class AggregationDataService(
	private val aggregationDataRepository: AggregationDataRepository
) {
	
	fun upsert(aggregations: List<Aggregation>, eventData: Map<String, Any>) = aggregations.forEach{
		try{
			this.upsert(it, eventData)
		}catch (e: Exception){
		}
	}
	
	fun upsert(aggregation: Aggregation, eventData: Map<String, Any>){
		val key = "${aggregation.name.toLowerCase()}-${eventData[aggregation.field.name]}"
		getByKey(key).ifPresentOrElse ({ update(it, eventData)  }, { insert(key, eventData)})
	}
	
	fun insert(key: String, eventData: Map<String, Any>) {
		aggregationDataRepository.insert(AggregationData(key=key))
	}
	
	fun getByKey(key: String) = aggregationDataRepository.findById(key)
	
	fun update(aggregationData: AggregationData, eventData: Map<String, Any>){
		aggregationDataRepository.save(
			aggregationData.copy(count = aggregationData.count + 1)
		)
	}
	
}