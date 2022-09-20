package dev.gustavoteixeira.rabbitmqpublisher.application;

import com.google.gson.Gson;
import dev.gustavoteixeira.rabbitmqpublisher.model.Registro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Publisher implements CommandLineRunner  {

    private final RabbitTemplate rabbitTemplate;
    private final Gson jsonConverter;

    @Override
    public void run(String... args) throws Exception {
        Registro registro = Registro.buildDefault();
        rabbitTemplate.convertAndSend("TestExchange", "testRouting", jsonConverter.toJson(registro));
    }

}
