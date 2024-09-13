import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		Banco banco = new Banco("Banco Cods");

		System.out.println("Digite o nome do usuario: ");
		String nome = entrada.nextLine();
		Usuario usuario = new Usuario(nome);

		System.out.println("Digite o tipo da conta: 1 - Conta Corrente 2 - Conta Poupança");
		String tipo = entrada.nextLine();

		Contas conta = null;

		switch (tipo) {
		case "1": {
			conta = Contas.ContaCorrente;
			break;
		}
		case "2": {
			conta = Contas.ContaPoupanca;
			break;
		}
		}
		
		banco.criarConta(usuario, conta);
		
		System.out.println("Digite o valor a ser depositado: ");
		double dinheiro =Double.valueOf(entrada.nextLine());
		usuario.getContaBase().depositar(dinheiro);
		System.out.println(usuario.getContaBase().toString());
		
		
		System.out.println("Digite o valor a ser sacado: ");
		dinheiro =Double.valueOf(entrada.nextLine());
		usuario.getContaBase().sacar(dinheiro);
		System.out.println(usuario.getContaBase().toString());
		
		entrada.close();

	}

}
