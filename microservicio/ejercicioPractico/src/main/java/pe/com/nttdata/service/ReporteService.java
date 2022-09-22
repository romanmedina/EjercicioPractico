package pe.com.nttdata.service;

import java.time.LocalDateTime;
import java.util.List;
import pe.com.nttdata.entity.Movimientos;

public interface ReporteService extends ICRUD<Movimientos, Integer>{

	List<Movimientos> reporteMovimientos(LocalDateTime from, LocalDateTime to);
}
