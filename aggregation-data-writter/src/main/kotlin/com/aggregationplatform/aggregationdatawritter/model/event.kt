package com.aggregationplatform.aggregationdatawritter.model

import com.aggregationplatform.aggregationdatawritter.model.FieldType.STRING

enum class Event(
	val fields: List<Field>
) {
	ORDER_CREATED(
		fields = listOf(
			Field(name = "customerId", path = "customerId", type = STRING)
		)
	)
	
	;
	
	fun fieldByName(name: String) = fields.first { it.name == name }
	
}

data class Field(
	val name: String,
	val path: String,
	val type: FieldType
)

enum class FieldType{
	STRING
}