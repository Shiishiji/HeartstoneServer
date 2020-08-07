package org.shiishiji.controller

import io.javalin.http.Context
import java.util.*

object UserController {

    fun getUsers(ctx: Context) {
        ctx.json("getUsers")
    }

}