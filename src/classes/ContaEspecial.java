package classes;
//NICOLE

public class ContaEspecial extends Conta {
	
	// Atributos
	
	private double limite = 1000;
	
	// Construtor e sobrecargas do construtor

	public ContaEspecial(int numero) {
		super(numero);
	}
	
	public ContaEspecial(int numero, double limite) {
		super(numero);
		this.limite = limite;
	}

	public ContaEspecial(int numero, String cpf, double limite) {
		super(numero, cpf);
		this.limite = limite;
	}

	public ContaEspecial(int numero, String cpf, boolean ativa, double limite) {
		super(numero, cpf, ativa);
		this.limite = limite;
	}
	
	// Encapsulamento

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	// M�todos override
	
	@Override
	public void debito(double valor) {	
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.printf("D�bito no valor de R$ %.2f realizado com sucesso.\n", valor);
		} 
		else {
			usarLimite(valor);
		}
		exibir();
	}
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Limite dispon�vel: R$ %.2f\n", getLimite());
	}
	
	// M�todos
	
	public double usarLimite(double valor) {
		if ((saldo + limite) >= valor) {
			double saldoAntigo = saldo;
			double limiteUtilizado = valor - saldo;
			limite = limite + (saldo - valor);
			saldo = saldo - valor + limiteUtilizado;
			System.out.printf("Voc� utilizou R$ %.2f do seu saldo e R$ %.2f do limite dispon�vel, "
					+ "totalizando o d�bito de R$ %.2f.\n", saldoAntigo, limiteUtilizado, valor);
		} else {
			System.out.printf("Voc� n�o possui saldo ou limite suficiente para realizar a movimenta��o.\n");
		}
		return limite;	
	}

}
