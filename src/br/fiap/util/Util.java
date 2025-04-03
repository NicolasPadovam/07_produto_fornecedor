package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.awt.*;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class Util {

    private Produto[] produto = new Produto[3];
    private Fornecedor[] fornecedor = new Fornecedor[3];
    private int indexProduto = 0;
    private int indexFornecedor = 0;


    public void menuPrincipal() {
        int opcao = 0;
        String menu = "1. Cadastrar Produto \n2.Pesquisar produto por nome \n3.Pesquisa fornecedor por CNPJ \n4.Finalizar";

        while (true) {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 4) {
                //break
                return;
            }
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisaProduto();
                    break;
                case 3:
                    pesquisaFornecedor();
                    break;
                default:
                    showMessageDialog(null, "Opção inválida");
            }
        }

    }


    private void cadastrarProduto() {
        String nome;
        double valor;
        int qtd;
        Fornecedor fornecedor = pesquisaFornecedor();

        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }
        nome = showInputDialog("Digite o nome do produto: ");
        valor = parseDouble(showInputDialog("Digite o valor do produto: "));
        qtd = parseInt(showInputDialog("Digite a quantidade em estoque; "));

        produto[indexProduto] = new Produto(nome, valor, qtd, fornecedor);
        //serve para aumentar o indice e sobrescrever os espaços do vetor vazios;
        indexProduto++;

    }

    private Fornecedor cadastrarFornecedor() {
        String nome = showInputDialog("Digite o nome do fornecedor: ");
        long cnpj = parseLong(showInputDialog("Digite o cnpj do fornecedor"));
        fornecedor[indexFornecedor] = new Fornecedor(nome, cnpj);
        // por ter somado o index++ para andar o vetor,
        indexFornecedor++;

        // preciso retornar -1 para pegar o ultimo numero colocado
        return fornecedor[indexFornecedor - 1];
    }


    private void pesquisaProduto() {
        //aux nasce com produto nao encontrado para caso não encontre no for, ja aparece uma mensagem
        String aux = "Produto não encontrado";
        String nome = showInputDialog("Nome do produto: ");

        for (int i = 0; i < indexProduto; i++) {
            if (produto[i].getNome().equalsIgnoreCase(nome)){
                //aux = "" -> zera a variavel
                aux = "";
                aux += "Nome do produto: "+nome +"\n";
                aux += "Valor unitário do produto: "+produto[i].getValor() +"\n";
                aux += "Fornecedor do produto: "+produto[i].getFornecedor().getNome() +"\n";
                aux += "Quantidade do produto: "+produto[i].getQtd() +"\n";
            }
        }
        showMessageDialog(null,aux);

    }

    private Fornecedor pesquisaFornecedor() {
        long cnpj = parseLong(showInputDialog("Digite o CNPJ"));

        //para acessar o objeto
        for (int i = 0; i < indexFornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "Esse cnpj não está cadastrado");
        return null;
    }


}
