package functionalTests;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotaFiscalTestTabelaDecisao {

    private GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    public void testeServicoConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(25.0, nf.getTaxaImpostoPorcent());
        Assertions.assertEquals(25.0, nf.getValorImposto());
    }

    @Test
    public void testeServicoTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(15.0, nf.getTaxaImpostoPorcent());
        Assertions.assertEquals(15.0, nf.getValorImposto());
    }

    @Test
    public void testeOutroServico() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "MANUTENCAO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(6.0, nf.getTaxaImpostoPorcent());
        Assertions.assertEquals(6.0, nf.getValorImposto());
    }
    
}
