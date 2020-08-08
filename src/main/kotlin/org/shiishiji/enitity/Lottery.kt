package org.shiishiji.enitity

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDate
import java.util.UUID

interface Lottery : Entity<Lottery> {
    companion object : Entity.Factory<Lottery>()
    val id: UUID
    val date: LocalDate
}