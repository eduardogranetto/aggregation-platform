package com.aggregationplatform.aggregationdatawritter.model

import com.aggregationplatform.aggregationdatawritter.model.Event.ORDER_CREATED

enum class Aggregation(
	val event: Event,
	val field: Field
){
	ORDERS_BY_CUSTOMER(ORDER_CREATED, ORDER_CREATED.fieldByName("customerId"))
}