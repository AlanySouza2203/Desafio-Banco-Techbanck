package com.Financeiro.banco;

public class ContaBancaria {

		private String numeroConta;
		private double saldo;
		private String Titular;
		
		public ContaBancaria(String numeroConta, double saldo, String Titular) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.Titular = Titular;
		
		}
		//Realiza depósito na conta
		public void depositar (double valor) {
			if (valor > 0) {
				saldo += valor;
				System.out.println("Depositar de R$" + valor + "Realizado com sucesso!");
				
			}
		}
		// Realiza o saque 
		public boolean sacar(double valor) {
			if (valor > 0 && saldo >= valor) {
				saldo -= valor;
				System.out.println("Saque de R$" + valor +  "Realizado com sucesso!");
				return true;
			}
			
			System.out.println("Saldo R$" + valor + " insuficiente");
			return false;
			
		}
		public String getnumeroConta() { return numeroConta;
		}
		public double getsaldo() { return saldo;
		}
		public String getTitular() { return Titular;
		}

	}
