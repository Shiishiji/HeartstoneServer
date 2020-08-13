package org.shiishiji.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.OpenApi
import io.javalin.plugin.openapi.annotations.OpenApiContent
import io.javalin.plugin.openapi.annotations.OpenApiResponse
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.sequenceOf
import org.shiishiji.enitity.Type
import org.shiishiji.model.Types

object TypeController {

    @OpenApi(
        summary = "Get all card types",
        operationId = "getTypes",
        tags = ["type"],
        responses = [OpenApiResponse("200", [OpenApiContent(Array<Type>::class)])]
    )
    fun getTypes(ctx: Context) {
        val database = Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorm",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = ""
        )
        val types = database.from(Types)
                            .select()
                            .orderBy(Types.value.asc())
                            .map { row -> Types.createEntity(row).toHashMap() }

        ctx.json(types.toList())
    }


}