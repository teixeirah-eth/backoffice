package dev.gustavoteixeira.backoffice.model.registro;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Registro {

    String description;

    String origin;

    LocalDateTime dateTime;

}
