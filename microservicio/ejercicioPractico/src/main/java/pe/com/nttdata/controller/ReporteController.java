package pe.com.nttdata.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.entity.Movimientos;
//import pe.com.nttdata.repository.IReporteRepository;
import pe.com.nttdata.service.ReporteService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

	@Autowired
	ReporteService reporteService;
	
	@GetMapping("/fecha")
	public List<Movimientos> reporte(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime from,
            						 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime to){
		return reporteService.reporteMovimientos(from, to);
	}
}
