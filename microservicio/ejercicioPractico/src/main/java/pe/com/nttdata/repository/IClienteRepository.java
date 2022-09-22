package pe.com.nttdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.nttdata.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
