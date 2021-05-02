package io.github.lexcao.tdd.java.reservation.entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Reservation {
    String name;
    LocalDateTime time;
}
