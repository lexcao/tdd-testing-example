package io.github.lexcao.tdd.java.reservation.service.impl;


import io.github.lexcao.tdd.java.reservation.entity.Reservation;
import io.github.lexcao.tdd.java.reservation.repository.ReservationRepository;
import io.github.lexcao.tdd.java.reservation.service.ReservationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public Reservation makeReservation(Reservation reservation) {
        return repository.save(reservation);
    }
}
