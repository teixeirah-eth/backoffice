package dev.gustavoteixeira.backoffice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

@Slf4j
public class RegistroListener implements MessageListener {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void onMessage(Message message) {
        log.info("Received message: {}.", new String(message.getBody()));
        log.info("Received message: {}.", gson.fromJson(new String(message.getBody()), Registro.class));
    }

}
