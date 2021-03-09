package classes;
//FELIPE
public class ContaEmpresa extends Conta {
	
	// Atributos
	
	private double emprestimoEmpresa = 10000;
	
	// Construtor e sobrecargas do construtor

	public ContaEmpresa(int numero) {
		super(numero);
	}
	
	public ContaEmpresa(int numero, double emprestimoEmpresa) {
		super(numero);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public ContaEmpresa(int numero, String cpf, double emprestimoEmpresa) {
		super(numero, cpf);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public ContaEmpresa(int numero, String cpf, boolean ativa, double emprestimoEmpresa) {
		super(numero, cpf, ativa);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// Encapsulamento

	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// M�todos override
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Empr�stimo dispon�vel: R$ %.2f\n", getEmprestimoEmpresa());
	}
	
	// M�todos
	
	public double pedirEmprestimo(double valor) {
		if (emprestimoEmpresa >= valor) {
			emprestimoEmpresa = emprestimoEmpresa - valor;
			saldo = saldo + valor;
			System.out.printf("Empr�stimo no valor de %.2f realizado com sucesso!\n", valor);
		}
		else {
			System.out.printf("Voc� n�o possui limite de empr�stimo suficiente para realizar a m.\n");
		}
		exibir();
		return emprestimoEmpresa;	
	}

}
