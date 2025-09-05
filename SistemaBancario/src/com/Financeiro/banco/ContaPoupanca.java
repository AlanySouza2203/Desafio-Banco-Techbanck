package com.Financeiro.banco;

public class ContaPoupanca extends ContaBancaria {
	private double TaxaRendimento;

	public ContaPoupanca(String numeroConta, double saldo, String Titular, double taxa) {
		super(numeroConta, saldo, Titular);
		this.TaxaRendimento = taxa;
	}

	public void aplicarRendimento(double valorAplicacao) {
        if (valorAplicacao > 0 && valorAplicacao <= getsaldo()) {
        	
            //  aplica o rendimento sobre o valor especificado
            double rendimento = valorAplicacao * (TaxaRendimento / 100);
            
            
            System.out.println("Aplicação de R$" + String.format("%.2f", valorAplicacao) + " realizada com sucesso!");
            System.out.println("Rendimento de " + TaxaRendimento + "%: R$" + String.format("%.2f", rendimento));
            System.out.println("Saldo total: R$" + String.format("%.2f", getsaldo()));
        } else {
            System.out.println("Valor inválido ou saldo insuficiente!");
        }
    }
    
    public double getTaxaRendimento() {
        return TaxaRendimento;
    }
}


