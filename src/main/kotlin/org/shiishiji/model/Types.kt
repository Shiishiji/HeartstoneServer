package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int

object Types : Table<Nothing>("t_type") {
    val id = int("id").primaryKey()
    val value = int("value")
}