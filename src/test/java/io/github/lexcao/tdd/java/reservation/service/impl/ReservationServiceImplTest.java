package io.github.lexcao.tdd.java.reservation.service.impl;

import io.github.lexcao.tdd.java.reservation.entity.Reservation;
import io.github.lexcao.tdd.java.reservation.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationServiceImplTest {

    private ReservationService service;

    @BeforeEach
    void setup() {
        service = new ReservationServiceImpl();
    }

    @Nested
    class MakeReservation {

        private final LocalDateTime time = LocalDateTime.of(2021, 5, 1, 21, 30);

        @Test
        void shouldSuccess() {
            // given
            Reservation reservation = new Reservation("Tome", time);

            // actual
            Reservation reserved = service.makeReservation(reservation);

            assertThat(reserved).isEqualTo(reservation);
        }
    }
}
