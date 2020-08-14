package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import io.javalin.plugin.openapi.annotations.OpenApiContent
import io.javalin.plugin.openapi.annotations.OpenApiRequestBody
import io.javalin.plugin.openapi.annotations.OpenApiResponse
import me.liuwj.ktorm.dsl.*
import org.shiishiji.Connection
import org.shiishiji.controller.request.user.AddUser
import org.shiishiji.controller.response.SuccessResponse
import org.shiishiji.model.Users

object UserController {

    private fun getDatabase() = Connection().getDatabase()

    @OpenApi(
        tags = ["user"],
        responses = [OpenApiResponse("200",[OpenApiContent(SuccessResponse::class)])]
    )
    fun getUsers(ctx: Context) {
        val users = getDatabase().from(Users)
            .select()
            .map { row -> Users.createEntity(row).toHashMap() }

        ctx.json(users.toList())
    }

    @OpenApi(
        summary = "Adds new user",
        operationId = "addUser",
        tags = ["user"],
        requestBody = OpenApiRequestBody([OpenApiContent(AddUser::class)]),
        responses = [OpenApiResponse("200",[OpenApiContent(SuccessResponse::class)])]
    )
    fun addUser(ctx: Context) {
        val user = ctx.body<AddUser>()
        val usersInDatabase = getDatabase().from(Users).select().where {
            Users.name like user.name
        }.map { row -> Users.createEntity(row) }

        if (usersInDatabase.count() == 0) {
            getDatabase().insert(Users) {
                it.name to user.name
            }
        }

        ctx.json(SuccessResponse(status = 1, message = "success"))
    }

}