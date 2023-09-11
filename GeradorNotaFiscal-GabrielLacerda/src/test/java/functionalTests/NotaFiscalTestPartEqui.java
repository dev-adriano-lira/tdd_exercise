package functionalTests;

import org.example.Fatura;
import org.example.GeradorNotaFiscal;
import org.example.NotaFiscal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.InvalidNameException;

public class NotaFiscalTestPartEqui {

    private GeradorNotaFiscal generator;

    @BeforeEach
    public void setup() {
        generator = new GeradorNotaFiscal();
    }

    @Test
    public void teste1() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(25, nf.getTaxaImpostoPorcent());
    }

    @Test
    public void teste2() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "TREINAMENTO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(15, nf.getTaxaImpostoPorcent());
    }

    @Test
    public void teste3() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "OUTRO", 100);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(06, nf.getTaxaImpostoPorcent());
    }

    @Test
    public void teste4() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 0);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(06, nf.getTaxaImpostoPorcent());
    }

    @Test
    public void teste5() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", 50);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertEquals(06, nf.getTaxaImpostoPorcent());
    }

    @Test
    public void teste6() {
        Fatura fatura = new Fatura("João Silva", "Rua das Flores, 123", "CONSULTORIA", -50);
        NotaFiscal nf = generator.gerarNotaFiscal(fatura);
        Assertions.assertThrows(InvalidNameException.class,() -> generator.gerarNotaFiscal(fatura));
    }


    @Test
    public void teste7() {
        Fatura fatura = new Fatura("", "Rua das Flores, 123", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura));
    }

    @Test
    public void teste8() {
        Fatura fatura = new Fatura("Joao@Silva", "Rua das Flores, 123", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura));
    }

    @Test
    public void teste9() {
        Fatura fatura = new Fatura("Joao@Silva", "", "CONSULTORIA", 100);
        Assertions.assertThrows(InvalidNameException.class, () -> generator.gerarNotaFiscal(fatura));
    }

}
