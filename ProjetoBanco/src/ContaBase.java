
public abstract class ContaBase {

	private final int agenciaPadrao = 0;
	private int numero;
	private double saldo;
	private double taxaPadrao;

	public ContaBase(int numero) {
		this.numero = numero;
	}

	public void sacar(double valor) {
		if (this.getClass().equals(ContaCorrente.class)) {
			valor += taxaPadrao;
		}

		if (getSaldo() >= (valor)) {
			setSaldo(getSaldo() - valor);
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
			setSaldo(getSaldo() - (valor + auxTaxa));
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTaxaPadrao() {
		return taxaPadrao;
	}

	public void setTaxaPadrao(double taxaPadrao) {
		this.taxaPadrao = taxaPadrao;
	}

}
