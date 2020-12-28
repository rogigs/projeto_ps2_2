package projeto.wsrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
	@Autowired
	private PedidoRepo pedidoRepo;
	
	@Autowired
	private ClienteFisicoRepo clienteFisicoRepo;
	
	@GetMapping("/api/clienteFisico/{pedidoId}/pedido")
	public List<Pedido> getPedidosByClienteFisicoId(@PathVariable long clienteFisicoId) {
		Optional<ClienteFisico> optionalClienteFisico = clienteFisicoRepo.findById(clienteFisicoId);
		if (!optionalClienteFisico.isPresent()) {
			return null;
		}
		ClienteFisico c = optionalClienteFisico.get();
		List<Pedido> pedidos = new ArrayList<>();
		pedidoRepo.findByClienteFisico(c.getId()).forEach(pedidos::add);
		return pedidos;
	}
	
	@PostMapping("/api/clienteFisico/{clienteFisicoId}/pedido")
	public Pedido createPedido(@PathVariable long clienteFisicoId ,@RequestBody Pedido p) {
		Optional<ClienteFisico> optionalClienteFisico = clienteFisicoRepo.findById(clienteFisicoId);
		if (!optionalClienteFisico.isPresent()) {
			return null;
		}
		ClienteFisico c = optionalClienteFisico.get();
		p.setClienteFisico(c);
		pedidoRepo.save(p);
		return p;
	}
	
	@PutMapping("/api/clienteFisico/{clienteFisicoId}/pedido/{pedidoId}")
	public Pedido updatePedido(@RequestBody Pedido pedidoRequest, @PathVariable long clienteFisicoId, @PathVariable long pedidoId) {
		Pedido pedido = null;
		pedido = this.getPedido(pedidoId);
		if (pedido == null) {
			return null;
		}
		
		Optional<ClienteFisico> optionalClienteFisico = clienteFisicoRepo.findById(clienteFisicoId);
		if (!optionalClienteFisico.isPresent()) {
			return null;
		}
		ClienteFisico c = optionalClienteFisico.get();
		
		pedido.setItem(pedidoRequest.getItem());
		pedido.setQuantidade(pedidoRequest.getQuantidade());
		pedido.setPreco(pedidoRequest.getPreco());
		pedido.setTotal(pedidoRequest.getTotal());
		pedido.setClienteFisico(c);
		pedidoRepo.save(pedido);
		return pedido;
	}
	
	
	
	
	
	@GetMapping("/api/pedido")
	public List<Pedido> getPedidos() {
		List<Pedido> pedidos = new ArrayList<>();
		pedidoRepo.findAll().forEach(pedidos::add);
		return pedidos;
	}

	@GetMapping("/api/pedido/{id}")
	public Pedido getPedido(@PathVariable long id) {
		Optional<Pedido> retorno = pedidoRepo.findById(id);
		Pedido c = null;
		if (retorno.isPresent()) {
			c = retorno.get();
		}
		return c;
	}

	@PostMapping("/api/pedido")
	public Pedido createPedido(@RequestBody Pedido p) {
		pedidoRepo.save(p);
		return p;
	}

	@PutMapping("/api/pedido/{id}")
	public Pedido updatePedido(@RequestBody Pedido p, @PathVariable long id) {
		Pedido pedido = null;
		pedido = this.getPedido(id);
		if (pedido != null) {
			pedidoRepo.save(p);
			pedido = p;
		}
		return pedido;
	}

	@DeleteMapping(value = "/api/pedido/{id}", produces = "application/json")
	public String deletePedido(@PathVariable long id) {
		Pedido pedido = this.getPedido(id);
		boolean result = false;
		if (pedido != null) {
			pedidoRepo.delete(pedido);
			result = true;
		}
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}
}
