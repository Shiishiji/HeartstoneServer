package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import io.javalin.plugin.openapi.annotations.OpenApiContent
import io.javalin.plugin.openapi.annotations.OpenApiResponse
import me.liuwj.ktorm.dsl.*
import org.shiishiji.Connection
import org.shiishiji.controller.response.LotteryResponse
import org.shiishiji.controller.response.Score
import org.shiishiji.controller.response.SuccessResponse
import org.shiishiji.enitity.Lottery
import org.shiishiji.model.Cards
import org.shiishiji.model.Lotteries
import org.shiishiji.model.Types
import org.shiishiji.model.Users
import java.time.ZoneId
import java.util.*

object LotteryController {

    private fun getDatabase() = Connection().getDatabase()

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
        summary = "Return scores for lottery with given uuid",
        operationId = "getLottery",
        tags = ["lottery"],
        responses = [OpenApiResponse("200", [OpenApiContent(LotteryResponse::class)])]
    )
    fun getLottery(ctx: Context) {
        val uuid = ctx.pathParam("id")
        val scores = getDatabase().from(Cards)
            .leftJoin(Users, on = Users.id eq Cards.owner)
            .leftJoin(Types, on = Types.id eq Cards.type)
            .leftJoin(Lotteries, on = Cards.lottery like Lotteries.id)
            .select(Users.name, sum(Types.value))
            .where { Lotteries.id like uuid }
            .map {row -> Score(
                points = row.getInt("sum(t_type.`value`)"),
                user = row.getString("t_user_nickname")!!
            )
        }

        ctx.json(LotteryResponse(message = "Returned lottery", data = scores))
    }

    @OpenApi(
        summary = "Adds new lottery",
        tags = ["lottery"]
    )
    fun addLottery(ctx: Context) {
        getDatabase().insert(Lotteries) {
            it.date to Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        }
        ctx.json(SuccessResponse(message = "Added lottery"))
    }

}