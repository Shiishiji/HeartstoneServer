package org.shiishiji.controller

import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import io.javalin.plugin.openapi.annotations.OpenApiContent
import io.javalin.plugin.openapi.annotations.OpenApiResponse
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.*
import org.shiishiji.Connection
import org.shiishiji.enitity.Type
import org.shiishiji.model.Types

object TypeController {

    private fun getDatabase() = Connection().getDatabase()

    @OpenApi(
        summary = "Get all card types",
        operationId = "getTypes",
        tags = ["type"],
        responses = [OpenApiResponse("200", [OpenApiContent(Array<Type>::class)])]
    )
    fun getTypes(ctx: Context) {
        val types = getDatabase().from(Types)
                            .select()
                            .orderBy(Types.value.asc())
                            .map { row -> Types.createEntity(row).toHashMap() }

        ctx.json(types.toList())
    }


}