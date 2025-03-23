 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

/**
 *
 * @author lucas
 */

// Bibliotecas

import java.util.Scanner;

// Classes e métodos

class ContaBancaria {
    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;    
    
    public ContaBancaria(String nome, String sobrenome, String cpf, double saldo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    // Consultar saldo
    public void consultarSaldo() {
        System.out.println("R$ " + saldo + " reais");
    }

    // Depositar valor
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("\nDeposito no valor de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("\nValor incorreto, por gentileza informar um valor válido para deposito.");
        }
    }

    // Sacar valor
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("\nSaque no valor de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido.");
        }
    }

    // Exibir menu
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--------Menu--------");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizr Saque");
            System.out.println("4. Encerrar");
            System.out.println("-----------------------");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nSeu saldo é de : ");
                    consultarSaldo();
                    break;

                case 2:
                    System.out.println("\nDigite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    depositar(valorDeposito);
                    break;

                case 3:
                    System.out.println("\nDigite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    sacar(valorSaque);
                    break;

                case 4:
                    System.out.println("\nEncerrando atendimento...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, seja muito bem-vindo(a) ao sistema bancário!");
        System.out.println("-------------------------------------------------");
        System.out.println("Por gentileza preencha os dados a seguir:");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("Digite seu cpf: ");
        String cpf = scanner.nextLine();

        ContaBancaria contaBancaria = new ContaBancaria(nome, sobrenome, cpf, 0.0);

        contaBancaria.exibirMenu();
        System.out.println("\n Obrigado por utilizar os nosso serviços!");
        scanner.close();
    }

}

