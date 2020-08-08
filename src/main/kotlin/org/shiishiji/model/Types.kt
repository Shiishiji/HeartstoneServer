package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar
import org.shiishiji.enitity.Type


object Types : Table<Type>("t_type") {
    var id = int("id").primaryKey().bindTo { it.id }
    var value = int("value").bindTo { it.value }
    var name = varchar("name").bindTo { it.name }
}