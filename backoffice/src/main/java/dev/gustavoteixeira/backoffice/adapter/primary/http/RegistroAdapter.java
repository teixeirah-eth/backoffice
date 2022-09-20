package dev.gustavoteixeira.backoffice.adapter.primary.http;

import dev.gustavoteixeira.backoffice.adapter.secondary.db.RegistroDocument;
import dev.gustavoteixeira.backoffice.application.Backoffice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/v1/registros")
@RequiredArgsConstructor
public class RegistroAdapter {

    private final Backoffice backoffice;

    @GetMapping
    public Flux<RegistroDocument> getRegistros() {
        return backoffice
                .getRegistros();
//                .map(registro -> RegistroDto.builder()
//                        .description(registro.getDescription())
//                        .origin(registro.getOrigin())
//                        .dateTime(registro.getDateTime())
//                        .build());
    }


}
