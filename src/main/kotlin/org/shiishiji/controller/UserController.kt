package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import java.util.*

object UserController {

    @OpenApi(
        tags = ["user"]
    )
    fun getUsers(ctx: Context) {
        ctx.json("getUsers")
    }

}