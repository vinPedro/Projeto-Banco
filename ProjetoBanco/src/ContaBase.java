

public abstract class ContaBase {

	private final int agenciaPadrao = 0;
	private int numero;
	private double saldo;
	private double taxaPadrao = 0.50;

	public ContaBase(int numero) {
		this.numero = numero;
	}

	public void sacar(double valor) {
		if (this.getClass().equals(ContaCorrente.class)) {
			valor += taxaPadrao;
		}

		if (getSaldo() >= (valor)) {
			this.saldo = (getSaldo() - valor);
		}

		else {
			System.out.println("SALDO INSUFICIENTE!");
		}

	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void transferir(double valor, ContaBase conta) {
		double auxTaxa = 0;
		if (this.getClass().equals(ContaCorrente.class)) {
			auxTaxa = taxaPadrao;
		}
		if (getSaldo() >= (valor + auxTaxa)) {
			this.saldo = getSaldo() - (valor + auxTaxa);
			conta.depositar(valor);
		} else {
			System.out.println("SALDO INSUFICIENTE!");
		}

	}

	public int getAgencia() {
		return agenciaPadrao;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getTaxaPadrao() {
		return taxaPadrao;
	}

	@Override
	public String toString() {
		return "ContaBase [saldo=" + saldo + "]";
	}

	
	
}
