package dev.gustavoteixeira.rabbitmqpublisher.model;


import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Value
@Builder
public class Registro {

    String description;

    String origin;

    LocalDateTime dateTime = now();

    public static Registro buildDefault() {
        return Registro.builder()
                .description("Simple description")
                .origin("RABBITMQ PUBLISHER APP")
                .build();
    }

}
