package io.github.lexcao.tdd.reservation.service.impl

import io.github.lexcao.tdd.reservation.causes.ReservationTimeNotAvailable
import io.github.lexcao.tdd.reservation.entity.Reservation
import io.github.lexcao.tdd.reservation.service.ReservationService

class ReservationServiceImpl(private val repository: ReservationRepository) : ReservationService {
    override fun makeReservation(reservation: Reservation): Reservation {
        val mayBeReserved = repository.findByTime(reservation.time)
        if (mayBeReserved != null) {
            throw ReservationTimeNotAvailable
        }

        return repository.save(reservation)
    }
}