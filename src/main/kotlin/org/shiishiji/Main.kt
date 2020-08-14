package org.shiishiji

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.OpenApiPlugin
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info
import org.shiishiji.controller.CardController
import org.shiishiji.controller.LotteryController
import org.shiishiji.controller.TypeController
import org.shiishiji.controller.UserController
import org.shiishiji.controller.response.ErrorResponse


fun main(args: Array<String>) {
    Javalin.create {
        it.registerPlugin(getConfiguredOpenApiPlugin())
        it.defaultContentType = "application/json"
    }
    .routes{
        path("users") {
            get(UserController::getUsers)
            put(UserController::addUser)
        }
        path("lotteries") {
            get(LotteryController::getLotteries)
            put(LotteryController::addLottery)
            path(":id") {
                get(LotteryController::getLottery)
            }
        }
        path("cards") {
            put(CardController::addCard)
        }
        path("types") {
            get(TypeController::getTypes)
        }
    }
    .start(7000)

    println("Check out Swagger UI docs at http://localhost:7000/")
}

fun getConfiguredOpenApiPlugin() = OpenApiPlugin(
    OpenApiOptions(
        Info()
            .title("ServerHS")
            .description("ServerHS")
            .version("1.0.0")
    ).apply {
        path("/swagger-docs")
        swagger(SwaggerOptions("/"))
        defaultDocumentation {doc ->
            doc.json("500", ErrorResponse::class.java)
            doc.json("503", ErrorResponse::class.java)
        }
    }
)