package org.padroes.chamado.estado;

import org.padroes.chamado.Chamado;

public interface EstadoChamado {
    void iniciarAtendimento(Chamado chamado);

    void resolver(Chamado chamado);

    void fechar(Chamado chamado);

    String getNome();
}

