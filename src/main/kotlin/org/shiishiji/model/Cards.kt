package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.*
import org.shiishiji.enitity.Card

object Cards : Table<Card>("t_card"){
    val id = int("id").primaryKey().bindTo { it.id }

}