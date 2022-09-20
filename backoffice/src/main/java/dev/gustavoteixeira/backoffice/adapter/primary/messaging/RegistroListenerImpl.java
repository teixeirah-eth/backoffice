package dev.gustavoteixeira.backoffice.adapter.primary.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.gustavoteixeira.backoffice.application.RegistroListener;
import dev.gustavoteixeira.backoffice.model.registro.Registro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistroListenerImpl implements MessageListener {

    private final Gson jsonConverter;
    private final RegistroListener registroListener;

    @Override
    public void onMessage(Message message) {
        log.info("Received message: {}.", new String(message.getBody()));
        var registro = jsonConverter.fromJson(new String(message.getBody()), Registro.class);
        log.info("Received message: {}.", registro);
        registroListener.consumir(registro);
    }


}
