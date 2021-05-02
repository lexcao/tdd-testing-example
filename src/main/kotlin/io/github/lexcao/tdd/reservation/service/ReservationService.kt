package io.github.lexcao.tdd.reservation.service

import io.github.lexcao.tdd.reservation.entity.Reservation

interface ReservationService {
    fun makeReservation(reservation: Reservation): Reservation
}
