package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity

interface Card : Entity<Card> {
    companion object : Entity.Factory<Card>()
    val id: Int
    val owner: User
    val lottery: Lottery
    val type: Type
}