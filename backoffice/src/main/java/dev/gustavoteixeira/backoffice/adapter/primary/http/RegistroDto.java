package dev.gustavoteixeira.backoffice.adapter.primary.http;


import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
class RegistroDto {

    String description;

    String origin;

    LocalDateTime dateTime;


}
