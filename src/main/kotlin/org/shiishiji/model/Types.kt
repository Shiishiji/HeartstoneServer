package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import org.shiishiji.enitity.Type


object Types : Table<Type>("t_type") {
    val id = int("id").primaryKey()
    val value = int("value")
}