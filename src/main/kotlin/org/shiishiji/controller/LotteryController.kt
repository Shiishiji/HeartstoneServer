package org.shiishiji.controller

import io.javalin.http.Context
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.*
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

    fun getLotteries(ctx: Context) {
        val lotteries = getDatabase().from(Lotteries)
            .select()
            .orderBy(Lotteries.date.desc())
            .map { row -> Lotteries.createEntity(row).toHashMap() }

        ctx.json(lotteries.toList())
    }

    fun getLottery(ctx: Context) {
        ctx.json("getLottery")
    }

    fun createLottery(ctx: Context) {
        ctx.json("createLottery")
    }

}