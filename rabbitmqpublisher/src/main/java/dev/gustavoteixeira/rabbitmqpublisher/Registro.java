package dev.gustavoteixeira.rabbitmqpublisher;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Registro {

    String description;

    String origin;

}
