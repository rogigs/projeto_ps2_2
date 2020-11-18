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
public class ClienteFisicoController {
	@Autowired
	private ClienteFisicoRepo clienteFisicoRepo;
	
	@GetMapping("/api/clienteFisico")
	public List<ClienteFisico> getClientesFisicos(){
		List<ClienteFisico> clientesFisicos = new ArrayList<>();
		clienteFisicoRepo.findAll().forEach(clientesFisicos::add);
		return clientesFisicos;
	}
	
	@GetMapping("/api/clienteFisico/{id}")
	public ClienteFisico getClienteFisico(@PathVariable long id) {
		Optional<ClienteFisico> retorno= clienteFisicoRepo.findById(id);
		ClienteFisico c=null;
		if(retorno.isPresent()) {
			c=retorno.get();
		}
		return c;
	}
	
	@PostMapping("/api/clienteFisico")
	public ClienteFisico createClienteFisico(@RequestBody ClienteFisico p) {
		clienteFisicoRepo.save(p);
		return p;
	}
	
	@PutMapping("/api/clienteFisico/{id}")
	public ClienteFisico updateClienteFisico(@RequestBody ClienteFisico p, @PathVariable long id) {
		ClienteFisico clienteFisico=null;
		clienteFisico=this.getClienteFisico(id);
		if(clienteFisico != null) {
			clienteFisicoRepo.save(p);
			clienteFisico=p;
		}
		return clienteFisico;
	}
	
	@DeleteMapping(value= "/api/clienteFisico/{id}", produces= "application/json")
	public String deleteClienteFisico(@PathVariable long id) {
		ClienteFisico clienteFisico = this.getClienteFisico(id);
		boolean result=false;
		if(clienteFisico != null) {
			clienteFisicoRepo.delete(clienteFisico);
			result= true;
		}
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}
}
