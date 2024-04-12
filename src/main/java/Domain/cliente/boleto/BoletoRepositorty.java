package Domain.cliente.boleto;

import Domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepositorty extends JpaRepository<Boleto,Long> {
}
