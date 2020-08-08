package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDate
import kotlin.collections.HashMap

interface Lottery : Entity<Lottery> {
    companion object : Entity.Factory<Lottery>()
    val id: String
    val date: LocalDate

    fun toHashMap() : HashMap<String, Any> {
        return hashMapOf(
            "id" to id,
            "date" to date
        )
    }
}