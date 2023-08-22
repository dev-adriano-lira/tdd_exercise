package org.example;

public class SAP {

    boolean check = false;
    public void envia(NotaFiscal nf) {
        System.out.println("Enviando nota fiscal para o SAP");
    }

    public boolean verificarSeNotaFoiEnviada(NotaFiscal notaFiscalGerada) {
        if (check) {
            return true;
        }
        return false;
    }
}
