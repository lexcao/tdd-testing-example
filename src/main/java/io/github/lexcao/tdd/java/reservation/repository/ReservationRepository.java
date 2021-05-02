package io.github.lexcao.tdd.java.reservation.repository;

import io.github.lexcao.tdd.java.reservation.entity.Reservation;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);

    Optional<Reservation> findByTime(LocalDateTime time);
}
