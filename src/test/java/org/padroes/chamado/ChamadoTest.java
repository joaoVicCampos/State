package org.padroes.chamado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.padroes.chamado.estado.EstadoChamado;

class ChamadoTest {

    @Test
    void deveIniciarComEstadoInformado() {
        EstadoTeste estadoInicial = new EstadoTeste("ABERTO");

        Chamado chamado = new Chamado("CH-001", "Falha no acesso", estadoInicial);

        assertEquals("CH-001", chamado.getProtocolo());
        assertEquals("Falha no acesso", chamado.getDescricao());
        assertEquals("ABERTO", chamado.getNomeEstado());
        assertSame(estadoInicial, chamado.getEstado());
    }

    @Test
    void devePermitirTrocarEstadoPeloContexto() {
        EstadoTeste aberto = new EstadoTeste("ABERTO");
        EstadoTeste emAtendimento = new EstadoTeste("EM_ATENDIMENTO");
        Chamado chamado = new Chamado("CH-002", "Erro no cadastro", aberto);

        chamado.setEstado(emAtendimento);

        assertSame(emAtendimento, chamado.getEstado());
        assertEquals("EM_ATENDIMENTO", chamado.getNomeEstado());
    }

    @Test
    void deveDelegarAcoesParaEstadoAtual() {
        EstadoTeste estado = new EstadoTeste("ABERTO");
        Chamado chamado = new Chamado("CH-003", "Sistema lento", estado);

        chamado.iniciarAtendimento();
        chamado.resolver();
        chamado.fechar();

        assertTrue(estado.iniciarChamado);
        assertTrue(estado.resolverChamado);
        assertTrue(estado.fecharChamado);
    }

    private static class EstadoTeste implements EstadoChamado {
        private final String nome;
        private boolean iniciarChamado;
        private boolean resolverChamado;
        private boolean fecharChamado;

        private EstadoTeste(String nome) {
            this.nome = nome;
        }

        @Override
        public void iniciarAtendimento(Chamado chamado) {
            iniciarChamado = true;
        }

        @Override
        public void resolver(Chamado chamado) {
            resolverChamado = true;
        }

        @Override
        public void fechar(Chamado chamado) {
            fecharChamado = true;
        }

        @Override
        public String getNome() {
            return nome;
        }
    }
}

