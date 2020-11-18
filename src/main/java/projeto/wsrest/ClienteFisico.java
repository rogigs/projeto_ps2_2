package projeto.wsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clienteFisico")
public class ClienteFisico{
	@Id @GeneratedValue
	private long id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	public ClienteFisico() {}
	public ClienteFisico(long id, String nome, String cpf, String dataNascimento, String email) {
		super();
		this.id = id;
		this.nome=nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email=email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
