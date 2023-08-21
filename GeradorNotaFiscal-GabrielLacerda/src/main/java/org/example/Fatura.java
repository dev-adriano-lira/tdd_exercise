package org.example;

public class Fatura {
    private String nomeCliente;
    private String enderecoCliente;
    private String tipoServico;
    private double valorFatura;

    public Fatura(String nomeCliente, String enderecoCliente, String tipoServico, double valorFatura) {
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.tipoServico = tipoServico;
        this.valorFatura = valorFatura;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public double calcularImposto() {
        if (tipoServico.equals("CONSULTORIA")) {
            return valorFatura * 0.25;
        } else if (tipoServico.equals("TREINAMENTO")) {
            return valorFatura * 0.15;
        } else {
            return valorFatura * 0.06;
        }
    }
}
