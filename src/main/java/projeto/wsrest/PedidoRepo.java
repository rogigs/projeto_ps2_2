package projeto.wsrest;

import org.springframework.data.repository.CrudRepository;

public interface PedidoRepo extends CrudRepository<Pedido, Long>{
	Iterable<Pedido> findByClienteFisico(long clienteFisicoId);
}
