package io.github.lexcao.tdd.java.reservation.repository;

import io.github.lexcao.tdd.java.reservation.entity.Reservation;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
}
