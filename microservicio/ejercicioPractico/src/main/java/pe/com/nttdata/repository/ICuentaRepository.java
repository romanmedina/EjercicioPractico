package pe.com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.entity.Cuenta;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Integer>{

}
