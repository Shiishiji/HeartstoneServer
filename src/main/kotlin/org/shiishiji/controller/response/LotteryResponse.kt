package org.shiishiji.controller.response

data class LotteryResponse (
    val status: Int = 1,
    val message: String,
    val data: List<Score>?
)