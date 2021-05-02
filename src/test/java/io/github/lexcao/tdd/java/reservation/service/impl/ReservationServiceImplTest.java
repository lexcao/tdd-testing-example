package io.github.lexcao.tdd.java.reservation.service.impl;

import io.github.lexcao.tdd.java.reservation.cause.ReservationTimeNotAvailable;
import io.github.lexcao.tdd.java.reservation.entity.Reservation;
import io.github.lexcao.tdd.java.reservation.repository.ReservationRepository;
import io.github.lexcao.tdd.java.reservation.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class ReservationServiceImplTest {

    private ReservationRepository mockRepository;
    private ReservationService service;

    @BeforeEach
    void setup() {
        mockRepository = Mockito.mock(ReservationRepository.class);
        service = new ReservationServiceImpl(mockRepository);
    }

    @Nested
    class MakeReservation {

        private final LocalDateTime time = LocalDateTime.of(2021, 5, 1, 21, 30);

        @Test
        void shouldSuccess() {
            // given
            Reservation reservation = new Reservation("Tome", time);
            given(mockRepository.findByTime(time)).willReturn(Optional.empty());
            given(mockRepository.save(any())).willReturn(reservation);

            // actual
            Reservation reserved = service.makeReservation(reservation);

            // verify
            then(mockRepository).should().findByTime(time);
            then(mockRepository).should().save(reservation);

            // expect
            assertThat(reserved).isEqualTo(reservation);
        }

        @Test
        void shouldFailure() {
            // given
            Reservation reservation = new Reservation("Tome", time);
            given(mockRepository.findByTime(time)).willReturn(Optional.of(reservation));
            given(mockRepository.save(any())).willReturn(reservation);

            // actual
            assertThatThrownBy(() -> service.makeReservation(reservation))
                .isExactlyInstanceOf(ReservationTimeNotAvailable.class);

            // verify
            then(mockRepository).should().findByTime(time);
            then(mockRepository).shouldHaveNoMoreInteractions();
        }
    }
}
