package org.shiishiji.controller

import io.javalin.http.Context

object LotteryController {

    fun getLotteries(ctx: Context) {
        ctx.json("getLotteries")
    }

    fun getLottery(ctx: Context) {
        ctx.json("getLottery")
    }

    fun createLottery(ctx: Context) {
        ctx.json("createLottery")
    }

}