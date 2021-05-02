package io.github.lexcao.tdd.reservation.service.impl

import io.github.lexcao.tdd.reservation.entity.Reservation
import io.github.lexcao.tdd.reservation.service.ReservationService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ReservationServiceImplTest {

    private val service: ReservationService = ReservationServiceImpl()

    @Nested
    inner class MakeReservation {

        private val time: LocalDateTime = LocalDateTime.of(2021, 5, 1, 21, 30)

        @Test
        fun shouldSuccess() {
            // given
            val reservation = Reservation(name = "Tom", time = time)

            // actual
            val reserved: Reservation = service.makeReservation(reservation)

            // expect
            reserved shouldBe reservation
        }
    }
}