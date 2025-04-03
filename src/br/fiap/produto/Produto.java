package br.fiap.produto;

import br.fiap.fornecedor.Fornecedor;

public class Produto {
    private String nome;
    private double valor;
    private int qtd;
    private Fornecedor fornecedor;

    public Produto(String nome, double valor, int qtd, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
