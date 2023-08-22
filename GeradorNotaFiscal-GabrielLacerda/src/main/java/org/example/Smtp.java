package org.example;

public class Smtp {
    boolean check = false;
    public void envia(NotaFiscal nf) {
            System.out.println("Enviando nota fiscal por e-mail");
        }

    public boolean verificarSeNotaFoiEnviada(NotaFiscal notaFiscalGerada) {
            if(check){
                return true;
            }
            return false;
    }
}

