package org.example;

import org.junit.jupiter.api.Test;
import  org.mockito.Mockito.*;

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
        NotaFiscal notaFiscal = new NotaFiscal("Cliente Persistencia", 200.0, 12.0);

        NotaFiscalDao notaFiscalDaoMock = mock(NotaFiscalDao.class);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal(notaFiscalDaoMock);
        gerador.gerarNotaFiscal(fatura);

        verify(notaFiscalDaoMock).salva(notaFiscal);
    }

    @Test
    void testEnvioNotaFiscalPorEmail() {
        Fatura fatura = new Fatura("Cliente Email", "Endereço Email", "OUTROS", 300.0);
        NotaFiscal notaFiscal = new NotaFiscal("Cliente Email", 300.0, 18.0);

        Smtp smtpMock = mock(Smtp.class);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal(smtpMock);
        gerador.gerarNotaFiscal(fatura);

        verify(smtpMock).envia(notaFiscal);
    }

    @Test
    void testEnvioNotaFiscalParaSAP() {
        Fatura fatura = new Fatura("Cliente SAP", "Endereço SAP", "OUTROS", 400.0);
        NotaFiscal notaFiscal = new NotaFiscal("Cliente SAP", 400.0, 24.0);

        SAP sapMock = mock(SAP.class);

        GeradorNotaFiscal gerador = new GeradorNotaFiscal(sapMock);
        gerador.gerarNotaFiscal(fatura);

        verify(sapMock).envia(notaFiscal);
    }
}
