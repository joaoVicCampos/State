package org.padroes.chamado.estado;

import org.padroes.chamado.Chamado;

public final class Aberto implements EstadoChamado {
    private static final Aberto INSTANCIA = new Aberto();

    private Aberto() {
    }

    public static Aberto getInstancia() {
        return INSTANCIA;
    }

    @Override
    public void iniciarAtendimento(Chamado chamado) {
        chamado.setEstado(EmAtendimento.getInstancia());
    }

    @Override
    public void resolver(Chamado chamado) {
        throw new IllegalStateException("Chamado ABERTO nao pode ser resolvido sem atendimento");
    }

    @Override
    public void fechar(Chamado chamado) {
        throw new IllegalStateException("Chamado ABERTO nao pode ser fechado nesta etapa");
    }

    @Override
    public String getNome() {
        return "ABERTO";
    }
}



