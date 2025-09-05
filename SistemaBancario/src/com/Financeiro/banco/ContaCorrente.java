package com.Financeiro.banco;

public class ContaCorrente extends ContaBancaria{
	private double LimiteChequeEspecial;

	 public ContaCorrente(String numeroConta, double saldo, String titular, double limiteChequeEspecial) {
	        super(numeroConta, saldo, titular);
	        this.LimiteChequeEspecial = limiteChequeEspecial;
	    }
	    
	    @Override
	    public boolean sacar(double valor) {
	        if (valor > 0) {
	            double saldoDisponivel = getsaldo() + LimiteChequeEspecial;;
	            
	            if (saldoDisponivel >= valor) {
	                if (getsaldo() >= valor) {
	                    // Sacar normalmente
	                    return super.sacar(valor);
	                } else {
	                    // Usar cheque especial 
	                    double valorUsandoCheque = valor - getsaldo();
	                    // Primeiro saca todo o saldo disponível
	                    super.sacar(getsaldo());
	                    // O uso do  cheque especial
	                    LimiteChequeEspecial -= valorUsandoCheque;
	                    System.out.println("Saque de R$" + valor + " realizado com sucesso! (R$" + 
	                                      (valor - valorUsandoCheque) + " do saldo + R$" + 
	                                      valorUsandoCheque + " do cheque especial)");
	                    return true;
	                }
	            } else {
	                System.out.println("Saldo insuficiente para saque de R$" + valor);
	                return false;
	            }
	        }
	        System.out.println("Valor de saque inválido!");
	        return false;
	    }
	    
	    public double getLimiteChequeEspecial() {
	        return LimiteChequeEspecial;
	    }

	}
