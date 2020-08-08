package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity

interface User : Entity<User> {
    companion object : Entity.Factory<User>()
    val id: Int
    var name: String
}