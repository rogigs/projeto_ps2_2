package projeto.wsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clienteJuridico")
public class ClienteJuridico{
	@Id @GeneratedValue
	private long id;
	private String nome;
	private String cnpj;
	private String email;
	public ClienteJuridico() {}
	public ClienteJuridico(long id, String nome, String cnpj, String email) {
		super();
		this.id = id;
		this.nome=nome;
		this.cnpj = cnpj;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

		public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
