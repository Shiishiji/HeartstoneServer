package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Users : Table<Nothing>("t_user") {
    val id = int("id").primaryKey()
    var name = varchar("nickname")
}