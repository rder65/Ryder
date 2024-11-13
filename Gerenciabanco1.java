package com.myprojetos.gerenciabanco1;

import java.util.Scanner;

/**
 *
 * @author nilza
 */
public class Gerenciabanco1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("seja bem-vindo ao sistema bancario");
        System.out.println("qual o seu nome");
        String nome = scanner.nextLine();
        System.out.println("seu sobrenome");
        String sobrenome = scanner.nextLine();
        System.out.println("seu cpf");
        String cpf = scanner.nextLine();

        cliente cliente = new cliente(nome, sobrenome, cpf);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n-----menu-----");
            System.out.println("1.consultar saldo");
            System.out.println("2.realizar o deposito");
            System.out.println("3.realizar saque");
            System.out.println("4.encerar");
            System.out.println("qual a opcao que você deseja escolher:");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 ->
                    cliente.consultarSaldo();

                case 2 -> {
                    System.out.println("digite o valor do deposito");
                    double ValorDeposito = scanner.nextDouble();
                    cliente.depositar(ValorDeposito);
                }

                case 3 -> {
                    System.out.println("digite o valor do saque");
                    double ValorSaque = scanner.nextDouble();
                    cliente.sacar(ValorSaque);
                }
                case 4 -> {
                    continuar = false;
                    System.out.println("enceramento volte sempre");
                }
                default -> {
                    System.out.println("opção invalida");
                    scanner.close();
                }
            }
        }

    }
}

class cliente {

    public String nome;
    public String sobrenome;
    public String cpf;
    private double saldo;

    public cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 100.0;
    }

    public void consultarSaldo() {

        System.out.println("seu saldo atual é: R$" + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("deposito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("saldo insuficiente");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("saldo insuficiente");
        }
    }
}
