package pe.com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.entity.Movimientos;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimientos, Integer>{

}
