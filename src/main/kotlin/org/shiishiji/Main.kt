package org.shiishiji

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.shiishiji.controller.CardController
import org.shiishiji.controller.LotteryController
import org.shiishiji.controller.TypeController
import org.shiishiji.controller.UserController

fun main(args: Array<String>) {
    val app = Javalin.create()
            .apply {
                exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
                error(404) { ctx -> ctx.json("error 404 - route not found") }
            }
            .start(7000)

    app.routes{
        path("users") {
            get(UserController::getUsers)

        }
        path("lotteries") {
            get(LotteryController::getLotteries)
            put(LotteryController::createLottery)
            path(":id") {
                get(LotteryController::getLottery)
            }
        }
        path("cards") {
            put(CardController::create)
        }
        path("types") {
            get(TypeController::getTypes)
        }
    }
}

