package org.padroes.chamado.estado;

import org.padroes.chamado.Chamado;

public final class EmAtendimento implements EstadoChamado {
    private static final EmAtendimento INSTANCIA = new EmAtendimento();

    private EmAtendimento() {
    }

    public static EmAtendimento getInstancia() {
        return INSTANCIA;
    }

    @Override
    public void iniciarAtendimento(Chamado chamado) {
        throw new IllegalStateException("Chamado EM_ATENDIMENTO ja esta em andamento");
    }

    @Override
    public void resolver(Chamado chamado) {
        chamado.setEstado(Resolvido.getInstancia());
    }

    @Override
    public void fechar(Chamado chamado) {
        throw new IllegalStateException("Chamado EM_ATENDIMENTO nao pode ser fechado nesta etapa");
    }

    @Override
    public String getNome() {
        return "EM_ATENDIMENTO";
    }
}



