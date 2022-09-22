package pe.com.nttdata.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.nttdata.entity.Movimientos;

@Repository
public interface IReporteRepository extends JpaRepository<Movimientos, Integer>{

	@Modifying
	@Transactional
	@Query("select m from Movimientos m where m.fecha BETWEEN :from and :to ")
	List<Movimientos> reporteEstadoCuenta(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
