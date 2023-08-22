package org.example;

public class NotaFiscalDao {
    boolean check = false;
    public void salva(NotaFiscal nf) {
        check = true;
        System.out.println("Salvando nota fiscal no banco de dados");
    }

    public boolean verificarSeNotaFoiSalva(NotaFiscal notaFiscalGerada) {
        if (check) {
            return true;
        }
        return false;
    }
}