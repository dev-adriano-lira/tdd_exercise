package junit5Tests;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotaFiscalTestTabelaDecisao {

    private  GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    @DisplayName("Teste para serviço de consultoria")
    public void testeServicoConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(25.0, nf.getTaxaImpostoPorcent(), "Taxa de imposto para CONSULTORIA deve ser 25%");
        Assertions.assertEquals(25.0, nf.getValorImposto(), "Valor do imposto para CONSULTORIA deve ser 25");
    }

    @Test
    @DisplayName("Teste para serviço de treinamento")
    public void testeServicoTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(15.0, nf.getTaxaImpostoPorcent(), "Taxa de imposto para TREINAMENTO deve ser 15%");
        Assertions.assertEquals(15.0, nf.getValorImposto(), "Valor do imposto para TREINAMENTO deve ser 15");
    }

    @Test
    @DisplayName("Teste para outros serviços")
    public void testeOutroServico() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "MANUTENCAO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(6.0, nf.getTaxaImpostoPorcent(), "Taxa de imposto para MANUTENCAO deve ser 6%");
        Assertions.assertEquals(6.0, nf.getValorImposto(), "Valor do imposto para MANUTENCAO deve ser 6");
    }
}
