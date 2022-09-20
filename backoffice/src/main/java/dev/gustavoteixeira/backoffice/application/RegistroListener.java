package dev.gustavoteixeira.backoffice.application;

import dev.gustavoteixeira.backoffice.model.registro.Registro;

public interface RegistroListener {

    void consumir(Registro registro);

}
