package org.shiishiji.controller.response

data class ErrorResponse(
    val title: String,
    val status: Int,
    val type: String,
    val details: Map<String, String>?
)