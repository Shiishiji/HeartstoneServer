package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi

object CardController {

    @OpenApi(
        tags = ["card"]
    )
    fun add(ctx: Context) {
        ctx.json("add")
    }

}