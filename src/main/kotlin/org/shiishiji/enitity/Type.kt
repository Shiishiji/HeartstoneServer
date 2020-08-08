package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity

interface Type : Entity<Type> {
    companion object : Entity.Factory<Type>()
    var id: Int
    var value: Int
    var name: String

    fun toHashMap() : HashMap<String, Any> {
        return hashMapOf(
            "id" to id,
            "name" to name,
            "value" to value
        )
    }
}