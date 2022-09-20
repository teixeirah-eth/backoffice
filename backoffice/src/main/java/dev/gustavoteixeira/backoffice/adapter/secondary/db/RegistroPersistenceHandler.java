package dev.gustavoteixeira.backoffice.adapter.secondary.db;

import dev.gustavoteixeira.backoffice.model.registro.Registro;
import dev.gustavoteixeira.backoffice.model.registro.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
class RegistroPersistenceHandler implements RegistroRepository {

    private final RegistroMongoRepository registroMongoRepository;

    @Override
    public Mono<String> save(Registro registro) {
        var document = RegistroDocument.builder().registros(Arrays.asList(registro)).build();
        return registroMongoRepository.save(document)
                .map(RegistroDocument::getId);
    }

    @Override
    public Flux<RegistroDocument> findAll() {
        return registroMongoRepository.findAll();
    }
}
