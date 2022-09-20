package dev.gustavoteixeira.backoffice.model.registro;

import dev.gustavoteixeira.backoffice.adapter.secondary.db.RegistroDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegistroRepository {

    Mono<String> save(Registro registro);

    Flux<RegistroDocument> findAll();

}
