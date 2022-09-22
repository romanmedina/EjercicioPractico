package pe.com.nttdata.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nttdata.entity.Movimientos;
import pe.com.nttdata.repository.IReporteRepository;
import pe.com.nttdata.service.ReporteService;

@Service
public class ReporteServiceImpl implements ReporteService{

	@Autowired
	IReporteRepository reporteRepo;
	
//	@Override
//	public List<Movimientos> reporteMovimientos(LocalDateTime from, LocalDateTime to) {
//		return reporteRepo.reporteEstadoCuenta(from, to);
//	}

}
