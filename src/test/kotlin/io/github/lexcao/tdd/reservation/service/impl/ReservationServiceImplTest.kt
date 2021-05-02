package io.github.lexcao.tdd.reservation.service.impl

import io.github.lexcao.tdd.reservation.causes.ReservationTimeNotAvailable
import io.github.lexcao.tdd.reservation.entity.Reservation
import io.github.lexcao.tdd.reservation.repository.ReservationRepository
import io.github.lexcao.tdd.reservation.service.ReservationService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.reset
import java.time.LocalDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ReservationServiceImplTest {

    private val mockRepository: ReservationRepository = mockk()
    private val service: ReservationService = ReservationServiceImpl(mockRepository)

    @AfterEach
    fun clear() {
        reset(mockRepository)
    }

    @Nested
    inner class MakeReservation {

        private val time: LocalDateTime = LocalDateTime.of(2021, 5, 1, 21, 30)

        @Test
        fun shouldSuccess() {
            // given
            val reservation = Reservation(name = "Tom", time = time)
            every { mockRepository.findByTime(time) } returns null
            every { mockRepository.save(any()) } returns reservation

            // actual
            val reserved: Reservation = service.makeReservation(reservation)

            // verify
            verifySequence {
                mockRepository.findByTime(time)
                mockRepository.save(reservation)
            }

            // expect
            reserved shouldBe reservation
        }

        @Test
        fun shouldFailure() {
            // given
            val reservation = Reservation(name = "Tom", time = time)
            every { mockRepository.findByTime(time) } returns reservation

            // actual
            shouldThrow<ReservationTimeNotAvailable> {
                service.makeReservation(reservation)
            }

            // verify
            verifySequence {
                mockRepository.findByTime(time)
                mockRepository.save(reservation) wasNot Called
            }
        }
    }
}