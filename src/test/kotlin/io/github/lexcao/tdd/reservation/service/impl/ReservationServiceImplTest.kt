package io.github.lexcao.tdd.reservation.service.impl

import io.github.lexcao.tdd.reservation.entity.Reservation
import io.github.lexcao.tdd.reservation.repository.ReservationRepository
import io.github.lexcao.tdd.reservation.service.ReservationService
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.time.LocalDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ReservationServiceImplTest {

    private val mockRepository: ReservationRepository = mockk()
    private val service: ReservationService = ReservationServiceImpl(mockRepository)

    @Nested
    inner class MakeReservation {

        private val time: LocalDateTime = LocalDateTime.of(2021, 5, 1, 21, 30)

        @Test
        fun shouldSuccess() {
            // given
            val reservation = Reservation(name = "Tom", time = time)
            every { mockRepository.save(any()) } returns reservation

            // actual
            val reserved: Reservation = service.makeReservation(reservation)

            // verify
            verifySequence {
                mockRepository.save(reservation)
            }

            // expect
            reserved shouldBe reservation
        }
    }
}