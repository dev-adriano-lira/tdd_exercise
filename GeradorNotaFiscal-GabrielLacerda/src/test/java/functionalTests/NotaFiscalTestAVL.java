package functionalTests;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotaFiscalTestAVL {

    private GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    public void testeLimiteInferiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    public void testeUmAcimaLimiteInferiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0025, nf.getValorImposto(), 0.0001);
    }

    @Test
    public void testeLimiteSuperiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(250, nf.getValorImposto());
    }

    @Test
    public void testeUmAbaixoLimiteSuperiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(2499.9975, nf.getValorImposto(), 0.0001);
    }


    @Test
    public void testeLimiteInferiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    public void testeUmAcimaLimiteInferiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0015, nf.getValorImposto(), 0.0001);
    }

    @Test
    public void testeLimiteSuperiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(150, nf.getValorImposto());
    }

    @Test
    public void testeUmAbaixoLimiteSuperiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(1499.9985, nf.getValorImposto(), 0.0001);
    }

    @Test
    public void testeLimiteInferior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    public void testeUmAcimaLimiteInferior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0006, nf.getValorImposto(), 0.0001);
    }

    @Test
    public void testeLimiteSuperior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(60, nf.getValorImposto());
    }

    @Test
    public void testeUmAbaixoLimiteSuperior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(599.99939, nf.getValorImposto(), 0.0001);
    }
}
