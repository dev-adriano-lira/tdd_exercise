package junit5Tests;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotaFiscalTestAVL {

    private  GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    @DisplayName("Teste Limite Inferior para Consultoria")
    public void testeLimiteInferiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Acima do Limite Inferior para Consultoria")
    public void testeUmAcimaLimiteInferiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0025, nf.getValorImposto(), 0.0001);
    }

    @Test
    @DisplayName("Teste Limite Superior para Consultoria")
    public void testeLimiteSuperiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(250, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Abaixo do Limite Superior para Consultoria")
    public void testeUmAbaixoLimiteSuperiorConsultoria() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(2499.9975, nf.getValorImposto(), 0.0001);
    }

    @Test
    @DisplayName("Teste Limite Inferior para Treinamento")
    public void testeLimiteInferiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Acima do Limite Inferior para Treinamento")
    public void testeUmAcimaLimiteInferiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0015, nf.getValorImposto(), 0.0001);
    }

    @Test
    @DisplayName("Teste Limite Superior para Treinamento")
    public void testeLimiteSuperiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(150, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Abaixo do Limite Superior para Treinamento")
    public void testeUmAbaixoLimiteSuperiorTreinamento() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(1499.9985, nf.getValorImposto(), 0.0001);
    }

    @Test
    @DisplayName("Teste Limite Inferior para Outro")
    public void testeLimiteInferior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Acima do Limite Inferior para Outro")
    public void testeUmAcimaLimiteInferior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 0.01);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(0.0006, nf.getValorImposto(), 0.0001);
    }

    @Test
    @DisplayName("Teste Limite Superior para Outro")
    public void testeLimiteSuperior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 1000);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(60, nf.getValorImposto());
    }

    @Test
    @DisplayName("Teste Um Abaixo do Limite Superior para Outro")
    public void testeUmAbaixoLimiteSuperior() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 9999.99);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(599.99939, nf.getValorImposto(), 0.0001);
    }
}
