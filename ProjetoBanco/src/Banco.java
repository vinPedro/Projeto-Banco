
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Usuario> usuarios;

	public Banco(String nome) {
		this.nome = nome;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void removerUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public void criarConta(Usuario usuario, Contas tipo) {
		ContaBase conta;
		if(tipo.equals(Contas.ContaCorrente)) {
			conta = new ContaCorrente();
			usuario.setContaBase(conta);
			adicionarUsuario(usuario);
		}
		else if(tipo.equals(Contas.ContaPoupanca)) {
			conta = new ContaPoupanca();
			usuario.setContaBase(conta);
			adicionarUsuario(usuario);
		}
		else {
			System.out.println("tipo de conta inválido");
		}
		
	}

	public String getNome() {
		return nome;
	}
}
