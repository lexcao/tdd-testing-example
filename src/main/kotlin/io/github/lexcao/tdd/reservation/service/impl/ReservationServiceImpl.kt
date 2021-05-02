package io.github.lexcao.tdd.reservation.service.impl

import io.github.lexcao.tdd.reservation.entity.Reservation
import io.github.lexcao.tdd.reservation.repository.ReservationRepository
import io.github.lexcao.tdd.reservation.service.ReservationService

class ReservationServiceImpl(private val repo: ReservationRepository) : ReservationService {
    override fun makeReservation(reservation: Reservation): Reservation {
        TODO()
    }
}