package org.example;

class NotaFiscal {
    private String nomeCliente;
    private double valorNota;
    private double valorImposto;

    public NotaFiscal(String nomeCliente, double valorNota, double valorImposto) {
        this.nomeCliente = nomeCliente;
        this.valorNota = valorNota;
        this.valorImposto = valorImposto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorNota() {
        return valorNota;
    }

    public double getValorImposto() {
        return valorImposto;
    }
}