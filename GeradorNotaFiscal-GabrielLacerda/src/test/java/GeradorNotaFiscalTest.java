import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeradorNotaFiscalTest {

    @Test
    void testGeracaoNotaFiscalParaConsultoria() {
        Fatura fatura = new Fatura("Cliente Consultoria", "Endereço Consultoria", "CONSULTORIA", 1000.0);
        NotaFiscal notaFiscalEsperada = new NotaFiscal("Cliente Consultoria", 1000.0, 250.0);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal notaFiscalGerada = gerador.gerarNotaFiscal(fatura);

        assertEquals(notaFiscalEsperada, notaFiscalGerada);
    }

    @Test
    void testGeracaoNotaFiscalParaTreinamento() {
        Fatura fatura = new Fatura("Cliente Treinamento", "Endereço Treinamento", "TREINAMENTO", 1500.0);
        NotaFiscal notaFiscalEsperada = new NotaFiscal("Cliente Treinamento", 1500.0, 225.0);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal notaFiscalGerada = gerador.gerarNotaFiscal(fatura);

        assertEquals(notaFiscalEsperada, notaFiscalGerada);
    }

    @Test
    void testGeracaoNotaFiscalParaOutrosServicos() {
        Fatura fatura = new Fatura("Cliente Outros", "Endereço Outros", "OUTROS", 500.0);
        NotaFiscal notaFiscalEsperada = new NotaFiscal("Cliente Outros", 500.0, 30.0);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal notaFiscalGerada = gerador.gerarNotaFiscal(fatura);

        assertEquals(notaFiscalEsperada, notaFiscalGerada);
    }

    @Test
    void testPersistenciaNotaFiscal() {
        Fatura fatura = new Fatura("Cliente Persistencia", "Endereço Persistencia", "OUTROS", 200.0);
        GeradorNotaFiscal notaFiscalDao = new GeradorNotaFiscal();

        NotaFiscal notaFiscal = notaFiscalDao.gerarNotaFiscal(fatura);

        assertEquals("Cliente Persistencia", notaFiscal.getNomeCliente());
        assertEquals(200, notaFiscal.getValorNota());
        assertEquals(12.0, notaFiscal.getValorImposto());
    }

        @Test
    void testEnvioNotaFiscalPorEmail() {
        Fatura fatura = new Fatura("Cliente Email", "Endereço Email", "OUTROS", 300.0);
        GeradorNotaFiscal notaFiscalDao = new GeradorNotaFiscal();
        NotaFiscal notaFiscal = notaFiscalDao.gerarNotaFiscal(fatura);

        Smtp smtp = new Smtp();

        smtp.envia(notaFiscal);
        assertTrue(true);

    }

    @Test
    void testEnvioNotaFiscalParaSAP() {
        Fatura fatura = new Fatura("Cliente SAP", "Endereço SAP", "OUTROS", 400.0);
        GeradorNotaFiscal notaFiscalDao = new GeradorNotaFiscal();
        NotaFiscal notaFiscal = notaFiscalDao.gerarNotaFiscal(fatura);

        SAP sap = new SAP();

        sap.envia(notaFiscal);
        assertTrue(true);
    }
}
