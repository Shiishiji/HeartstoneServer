package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.*

object Cards : Table<Nothing>("t_card"){
    val id = int("id").primaryKey()

}