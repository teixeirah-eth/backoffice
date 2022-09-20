package dev.gustavoteixeira.backoffice.application;

import dev.gustavoteixeira.backoffice.adapter.secondary.db.RegistroDocument;
import dev.gustavoteixeira.backoffice.model.registro.Registro;
import dev.gustavoteixeira.backoffice.model.registro.RegistroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class Backoffice implements RegistroListener {

    private final RegistroRepository registroRepository;

    @Override
    public void consumir(Registro registro) {
        log.info("Consumed message: {}.", registro);
        registroRepository.save(registro)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
    }

    public Flux<RegistroDocument> getRegistros() {
        return registroRepository.findAll();
    }
}
