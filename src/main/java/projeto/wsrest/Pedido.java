package projeto.wsrest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue
	private long id;
	private String item;
	private int quantidade;
	private int preco;
	private int total;

	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	private ClienteFisico clienteFisico;
	
	public ClienteFisico getClienteFisico() {
		return clienteFisico;
	}

	public void setClienteFisico(ClienteFisico clienteFisico) {
		this.clienteFisico = clienteFisico;
	}
	
//	@ManyToOne(fetch=FetchType.EAGER, optional = false)
//	private ClienteJuridico clienteJuridico;
//
//	public ClienteJuridico getClienteJuridico() {
//		return clienteJuridico;
//	}
//
//	public void setClienteJuridico(ClienteJuridico clienteJuridico) {
//		this.clienteJuridico = clienteJuridico;
//	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Pedido() {
	}

	public Pedido(long id, String item, int quantidade, int preco, int total) {
		super();
		this.id = id;
		this.item = item;
		this.quantidade = quantidade;
		this.preco = preco;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

}
