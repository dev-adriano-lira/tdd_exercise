package org.example;

public class GeradorNotaFiscal {
    public NotaFiscal gerarNotaFiscal(Fatura fatura) {
        double valorImposto = fatura.calcularImposto();
        NotaFiscal notaFiscal = new NotaFiscal(fatura.getNomeCliente(), fatura.getValorFatura(), valorImposto);

        NotaFiscalDao notaFiscalDao = new NotaFiscalDao();
        notaFiscalDao.salva(notaFiscal);

        SAP sap = new SAP();
        sap.envia(notaFiscal);

        Smtp smtp = new Smtp();
        smtp.envia(notaFiscal);

        return notaFiscal;
    }
}