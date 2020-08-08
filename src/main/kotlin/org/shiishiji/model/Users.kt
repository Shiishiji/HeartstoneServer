package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar
import org.shiishiji.enitity.User

object Users : Table<User>("t_user") {
    val id = int("id").primaryKey().bindTo { it.id }
    var name = varchar("nickname").bindTo { it.name }
}