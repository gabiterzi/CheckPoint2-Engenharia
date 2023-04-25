package entidades;

public class Mensagem {
	String nome, emailTel;
	public String mensagem;
	int motivo;
	
	public Mensagem(String nome, String emailTel, int motivo, String mensagem) {
		this.nome = nome;
		this.emailTel = emailTel;
		this.motivo = motivo;
		this.mensagem = mensagem;
		
	}

	public String toString() {
		return "Mensagem [nome=" + nome + ", emailTel=" + emailTel + ", mensagem=" + mensagem + ", motivo=" + motivo
				+ "]";
	}
	
}
