package org.shiishiji.controller

import io.javalin.http.Context

object CardController {

    fun add(ctx: Context) {
        ctx.json("add")
    }

}