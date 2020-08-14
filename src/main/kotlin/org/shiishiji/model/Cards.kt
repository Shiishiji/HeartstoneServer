package org.shiishiji.model

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.*
import org.shiishiji.enitity.Card

object Cards : Table<Card>("t_card"){
    val id = int("id").primaryKey().bindTo { it.id }
    var owner = int("owner").references(Users) { it.owner }
    var lottery = uuid("lottery").references(Lotteries) { it.lottery }
    var type = int("type").references(Types) { it.type }
}