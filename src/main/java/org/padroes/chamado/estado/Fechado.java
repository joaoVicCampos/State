package org.padroes.chamado.estado;

import org.padroes.chamado.Chamado;

public final class Fechado implements EstadoChamado {
    private static final Fechado INSTANCIA = new Fechado();

    private Fechado() {
    }

    public static Fechado getInstancia() {
        return INSTANCIA;
    }

    @Override
    public void iniciarAtendimento(Chamado chamado) {
        throw new IllegalStateException("Chamado FECHADO nao pode voltar para atendimento");
    }

    @Override
    public void resolver(Chamado chamado) {
        throw new IllegalStateException("Chamado FECHADO nao pode ser resolvido novamente");
    }

    @Override
    public void fechar(Chamado chamado) {
        throw new IllegalStateException("Chamado FECHADO ja esta encerrado");
    }

    @Override
    public String getNome() {
        return "FECHADO";
    }
}

