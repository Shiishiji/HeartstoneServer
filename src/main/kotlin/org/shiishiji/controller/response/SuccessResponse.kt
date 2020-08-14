package org.shiishiji.controller.response

data class SuccessResponse (
    val status: Int = 1,
    val message: String,
    val data: HashMap<String, Any>? = HashMap<String, Any>()
)