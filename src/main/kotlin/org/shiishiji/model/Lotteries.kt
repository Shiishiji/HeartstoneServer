package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.uuid
import me.liuwj.ktorm.schema.date

object Lotteries : Table<Nothing>("t_lottery") {
    val id = uuid("id").primaryKey()
    val date = date("date")
}