package com.Financeiro.banco;

import com.Financeiro.banco.ContaBancaria;
import com.Financeiro.banco.ContaCorrente;
import com.Financeiro.banco.ContaPoupanca;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("===== Sistema Bancário techBanck =====");
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        
        System.out.println("Bem-vindo, " + nomeUsuario + "!");
        
        System.out.println("==== Conta Corrente ====");
        ContaCorrente contaCorrente = new ContaCorrente("12345-6",000.0, nomeUsuario, 500.0);
        
        System.out.println("Titular: " + contaCorrente.getTitular());
        System.out.println("Saldo inicial: R$" + String.format("%.2f", contaCorrente.getsaldo()));
        
        System.out.println("\n--- CONTA POUPANÇA ---");
        ContaPoupanca contaPoupanca = new ContaPoupanca("09876-5", 000.0, nomeUsuario, 0.5);
        System.out.println("Titular: " + contaPoupanca.getTitular());
        System.out.println("Saldo inicial: R$" + String.format("%.2f", contaPoupanca.getsaldo()));

        do {
            System.out.println("\n=========== MENU PRINCIPAL ===========");
            System.out.println("1️- Depositar em Conta Corrente");
            System.out.println("2️- Sacar de Conta Corrente");
            System.out.println("3️- Depositar em Poupança");
            System.out.println("4️- Sacar de Poupança");
            System.out.println("5️- Aplicar Rendimento na Poupança");
            System.out.println("6- Ver Saldos");
            System.out.println("7- Ver Informações das Contas");
            System.out.println("0️- Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print(" Valor para depositar na conta corrente: R$ ");
                    double valorDepositoCC = scanner.nextDouble();
                    contaCorrente.depositar(valorDepositoCC);
                    break;
                    
                case 2:
                    System.out.print(" Valor para sacar da conta corrente: R$ ");
                    double valorSaqueCC = scanner.nextDouble();
                    contaCorrente.sacar(valorSaqueCC);
                    break;
                    
                case 3:
                    System.out.print(" Valor para depositar na poupança: R$ ");
                    double valorDepositoCP = scanner.nextDouble();
                    contaPoupanca.depositar(valorDepositoCP);
                    break;
                    
                case 4:
                    System.out.print(" Valor para sacar da poupança: R$ ");
                    double valorSaqueCP = scanner.nextDouble();
                    contaPoupanca.sacar(valorSaqueCP);
                    break;
                    
                case 5:
                	System.out.print(" Valor que deseja aplicar na poupança: R$ ");
                    double valorAplicacao = scanner.nextDouble();
                    contaPoupanca.aplicarRendimento(valorAplicacao); 
                    break;
                    
                case 6:
                    System.out.println("\n=== SALDOS ATUAIS ===");
                    System.out.println("Conta Corrente: R$ " + String.format("%.2f", contaCorrente.getsaldo()));
                    System.out.println("Conta Poupança: R$ " + String.format("%.2f", contaPoupanca.getsaldo()));
                    break;
                    
                case 7:
                    System.out.println("\n=== INFORMAÇÕES DAS CONTAS ===");
                    System.out.println("CONTA CORRENTE:");
                    System.out.println("Titular: " + contaCorrente.getTitular());
                    System.out.println("Número: " + contaCorrente.getnumeroConta());
                    System.out.println("Saldo: R$ " + String.format("%.2f", contaCorrente.getsaldo()));
                    System.out.println("Limite Cheque Especial: R$ " + String.format("%.2f", contaCorrente.getLimiteChequeEspecial()));
                    
                    System.out.println("\nCONTA POUPANÇA:");
                    System.out.println("Titular: " + contaPoupanca.getTitular());
                    System.out.println("Número: " + contaPoupanca.getnumeroConta());
                    System.out.println("Saldo: R$ " + String.format("%.2f", contaPoupanca.getsaldo()));
                    System.out.println("Taxa Rendimento: " + contaPoupanca.getTaxaRendimento() + "%");
                    break;
                    
                case 0:
                    System.out.println("\n--- RESUMO FINAL ---");
                    System.out.println("Saldo final conta corrente: R$ " + String.format("%.2f", contaCorrente.getsaldo()));
                    System.out.println("Saldo final conta poupança: R$ " + String.format("%.2f", contaPoupanca.getsaldo()));
                    System.out.println("\nSaindo do sistema. Obrigado por usar o TechBank, " + nomeUsuario + "!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Por favor, tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); 
                scanner.nextLine(); 
            }
            
        } while (opcao != 0);
        
        scanner.close();
        System.out.println("Sistema bancário finalizado com sucesso!");
    }
}