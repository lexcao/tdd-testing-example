package io.github.lexcao.tdd.reservation.repository

import io.github.lexcao.tdd.reservation.entity.Reservation
import java.time.LocalDateTime

interface ReservationRepository {
    fun save(entity: Reservation): Reservation
    fun findByTime(time: LocalDateTime): Reservation?
}