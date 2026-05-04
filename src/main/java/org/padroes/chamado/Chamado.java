package org.padroes.chamado;

import java.util.Objects;
import org.padroes.chamado.estado.EstadoChamado;

public class Chamado {
    private final String protocolo;
    private final String descricao;
    private EstadoChamado estado;

    public Chamado(String protocolo, String descricao, EstadoChamado estadoInicial) {
        this.protocolo = Objects.requireNonNull(protocolo, "protocolo obrigatorio");
        this.descricao = Objects.requireNonNull(descricao, "descricao obrigatoria");
        setEstado(estadoInicial);
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public EstadoChamado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getNome();
    }

    public void setEstado(EstadoChamado estado) {
        this.estado = Objects.requireNonNull(estado, "estado obrigatorio");
    }

    public void iniciarAtendimento() {
        estado.iniciarAtendimento(this);
    }

    public void resolver() {
        estado.resolver(this);
    }

    public void fechar() {
        estado.fechar(this);
    }
}

