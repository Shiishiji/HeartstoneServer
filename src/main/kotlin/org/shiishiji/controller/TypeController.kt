package org.shiishiji.controller

import io.javalin.http.Context

object TypeController {

    fun getTypes(ctx: Context) {
        ctx.json("getTypes")
    }

}