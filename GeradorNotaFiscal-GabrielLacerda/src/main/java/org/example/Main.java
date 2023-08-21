package org.example;

public class Main {
    public static void main(String[] args) {
        Fatura fatura = new Fatura("Cliente Exemplo", "Rua do Cliente, 123", "CONSULTORIA", 1000.0);
        GeradorNotaFiscal geradorNotaFiscal = new GeradorNotaFiscal();
        NotaFiscal notaFiscal = geradorNotaFiscal.gerarNotaFiscal(fatura);

        System.out.println("Nota fiscal gerada para o cliente: " + notaFiscal.getNomeCliente());
        System.out.println("Valor da nota fiscal: " + notaFiscal.getValorNota());
        System.out.println("Valor do imposto: " + notaFiscal.getValorImposto());
    }
}