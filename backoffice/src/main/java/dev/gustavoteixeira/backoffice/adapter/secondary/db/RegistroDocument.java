package dev.gustavoteixeira.backoffice.adapter.secondary.db;

import dev.gustavoteixeira.backoffice.model.registro.Registro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "registros")
public class RegistroDocument {

    @Id
    private String id;

    List<Registro> registros;

}
