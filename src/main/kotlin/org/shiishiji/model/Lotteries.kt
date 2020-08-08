package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.uuid
import me.liuwj.ktorm.schema.date
import org.shiishiji.enitity.Lottery

object Lotteries : Table<Lottery>("t_lottery") {
    val id = uuid("id").primaryKey().bindTo { it.id }
    val date = date("date").bindTo { it.date }
}