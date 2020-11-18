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
public class ClienteJuridicoController {
	@Autowired
	private ClienteJuridicoRepo clienteJuridicoRepo;
	
	@GetMapping("/api/clienteJuridico")
	public List<ClienteJuridico> getClientesJuridicos(){
		List<ClienteJuridico> clientesJuridicos= new ArrayList<>();
		clienteJuridicoRepo.findAll().forEach(clientesJuridicos::add);
		return clientesJuridicos;
	}
	
	@GetMapping("/api/clienteJuridico/{id}")
	public ClienteJuridico getClienteJuridico(@PathVariable long id) {
		Optional<ClienteJuridico> retorno= clienteJuridicoRepo.findById(id);
		ClienteJuridico c=null;
		if(retorno.isPresent()) {
			c=retorno.get();
		}
		return c;
	}
	
	@PostMapping("/api/clienteJuridico")
	public ClienteJuridico createClienteJuridico(@RequestBody ClienteJuridico p) {
		clienteJuridicoRepo.save(p);
		return p;
	}
	
	@PutMapping("/api/clienteJuridico/{id}")
	public ClienteJuridico updateClienteJuridico(@RequestBody ClienteJuridico p, @PathVariable long id) {
		ClienteJuridico clienteJuridico=null;
		clienteJuridico=this.getClienteJuridico(id);
		if(clienteJuridico != null) {
			clienteJuridicoRepo.save(p);
			clienteJuridico=p;
		}
		return clienteJuridico;
	}
	
	@DeleteMapping(value= "/api/clienteJuridico/{id}", produces= "application/json")
	public String deleteClienteJuridico(@PathVariable long id) {
		ClienteJuridico clienteJuridico = this.getClienteJuridico(id);
		boolean result=false;
		if(clienteJuridico != null) {
			clienteJuridicoRepo.delete(clienteJuridico);
			result= true;
		}
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}
}
