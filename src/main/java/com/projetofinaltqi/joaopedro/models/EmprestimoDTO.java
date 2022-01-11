package com.projetofinaltqi.joaopedro.models;

import java.util.Date;

public class EmprestimoDTO {

    public EmprestimoDTO (Emprestimo emprestimo){

        this.codigo = emprestimo.getCodigo();
        this.valor = emprestimo.getValor();
        this.quantidadeParcelas = emprestimo.getQuantidadeParcelas();

    }

    private long codigo;
    private double valor;
    private int quantidadeParcelas;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }
}
