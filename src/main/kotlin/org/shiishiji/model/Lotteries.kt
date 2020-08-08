package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.date
import me.liuwj.ktorm.schema.varchar
import org.shiishiji.enitity.Lottery

object Lotteries : Table<Lottery>("t_lottery") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val date = date("date").bindTo { it.date }
}