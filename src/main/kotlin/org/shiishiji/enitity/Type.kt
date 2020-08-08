package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity

interface Type : Entity<Type> {
    companion object : Entity.Factory<Type>()
    val id: Int
    val value: Int
}