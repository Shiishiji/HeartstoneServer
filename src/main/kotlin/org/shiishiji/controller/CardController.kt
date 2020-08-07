package org.shiishiji.controller

import io.javalin.http.Context

object CardController {

    fun create(ctx: Context) {
        ctx.json("create")
    }

}