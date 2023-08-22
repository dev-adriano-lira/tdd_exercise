package org.example;

import java.util.Objects;

public class NotaFiscal {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscal that = (NotaFiscal) o;
        return Double.compare(that.valorNota, valorNota) == 0 && Double.compare(that.valorImposto, valorImposto) == 0 && Objects.equals(nomeCliente, that.nomeCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCliente, valorNota, valorImposto);
    }
}