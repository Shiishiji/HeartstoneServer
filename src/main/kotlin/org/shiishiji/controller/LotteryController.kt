package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import io.javalin.plugin.openapi.annotations.OpenApiContent
import io.javalin.plugin.openapi.annotations.OpenApiResponse
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.*
import org.shiishiji.enitity.Lottery
import org.shiishiji.model.Lotteries
import org.shiishiji.model.Types

object LotteryController {

    private fun getDatabase() : Database {
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorm",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = ""
        )
    }

    @OpenApi(
        summary = "Get all lotteries",
        operationId = "getLotteries",
        tags = ["lottery"],
        responses = [OpenApiResponse("200", [OpenApiContent(Array<Lottery>::class)])]
    )
    fun getLotteries(ctx: Context) {
        val lotteries = getDatabase().from(Lotteries)
            .select()
            .orderBy(Lotteries.date.desc())
            .map { row -> Lotteries.createEntity(row).toHashMap() }

        ctx.json(lotteries.toList())
    }

    @OpenApi(
        tags = ["lottery"]
    )
    fun getLottery(ctx: Context) {
        ctx.json("getLottery")
    }

    @OpenApi(
        tags = ["lottery"]
    )
    fun createLottery(ctx: Context) {
        ctx.json("createLottery")
    }

}