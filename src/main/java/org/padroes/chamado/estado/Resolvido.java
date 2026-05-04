package org.padroes.chamado.estado;

import org.padroes.chamado.Chamado;

public final class Resolvido implements EstadoChamado {
    private static final Resolvido INSTANCIA = new Resolvido();

    private Resolvido() {
    }

    public static Resolvido getInstancia() {
        return INSTANCIA;
    }

    @Override
    public void iniciarAtendimento(Chamado chamado) {
        throw new IllegalStateException("Chamado RESOLVIDO nao pode voltar para atendimento");
    }

    @Override
    public void resolver(Chamado chamado) {
        throw new IllegalStateException("Chamado RESOLVIDO ja foi concluido tecnicamente");
    }

    @Override
    public void fechar(Chamado chamado) {
        throw new IllegalStateException("Estado FECHADO sera implementado na proxima etapa");
    }

    @Override
    public String getNome() {
        return "RESOLVIDO";
    }
}

