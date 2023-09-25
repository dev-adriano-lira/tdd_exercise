package junit5Tests;

import org.example.Fatura;
import org.example.GeradorNotaFiscal;
import org.example.NotaFiscal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

public class NotaFiscalTestPartEqui {

    private  GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    @DisplayName("Teste para serviço de consultoria com valor 100")
    public void teste1() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(25, nf.getTaxaImpostoPorcent(), "Taxa de imposto para CONSULTORIA deve ser 25%");
    }

    @Test
    @DisplayName("Teste para serviço de treinamento com valor 100")
    public void teste2() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(15, nf.getTaxaImpostoPorcent(), "Taxa de imposto para TREINAMENTO deve ser 15%");
    }

    @Test
    @DisplayName("Teste para outros serviços com valor 100")
    public void teste3() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(6, nf.getTaxaImpostoPorcent(), "Taxa de imposto para OUTRO deve ser 6%");
    }

    @Test
    @DisplayName("Teste para serviço de consultoria com valor 0")
    public void teste4() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.fail("Valor vázio para fatura");
    }

    @Test
    @DisplayName("Teste para serviço de consultoria com valor 50")
    public void teste5() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 50);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(6, nf.getTaxaImpostoPorcent(), "Taxa de imposto para valor 50 deve ser 6%");
    }

    @Test
    @DisplayName("Teste para valor negativo")
    public void teste6() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", -50);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura), "Deve lançar InvalidNameException para valor negativo");
    }

    @Test
    @DisplayName("Teste para nome vazio")
    public void teste7() {
        Fatura fatura = new Fatura("", "Rua das Flores, 123", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura), "Deve lançar InvalidNameException para nome vazio");
    }

    @Test
    @DisplayName("Teste para nome inválido com caracteres especiais")
    public void teste8() {
        Fatura fatura = new Fatura("Joao@Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura), "Deve lançar InvalidNameException para nome com caracteres especiais");
    }

    @Test
    @DisplayName("Teste para endereço vazio")
    public void teste9() {
        Fatura fatura = new Fatura("Joao@Silva", "", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura), "Deve lançar InvalidNameException para endereço vazio");
    }
}
