package org.shiishiji.controller.response

data class FailureResponse (
    val status: Int = 0,
    val message: String,
    val data: HashMap<String, String>? = HashMap<String, String>()
)