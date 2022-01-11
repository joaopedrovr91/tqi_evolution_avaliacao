package com.projetofinaltqi.joaopedro.models;

import java.util.Date;

public class EmprestimoDetDTO {

    private long codigo;
    private double valor;
    private Date dataPrimeiraParcela;
    private int quantidadeParcelas;
    private String email;
    private double renda;

    public EmprestimoDetDTO (Emprestimo emprestimo, Cliente cliente){

        this.codigo = emprestimo.getCodigo();
        this.valor = emprestimo.getValor();
        this.dataPrimeiraParcela = emprestimo.getDataPrimeiraParcela();
        this.quantidadeParcelas = emprestimo.getQuantidadeParcelas();
        this.email = cliente.getEmail();
        this.renda = cliente.getRenda();

    }

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

    public Date getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }
}
