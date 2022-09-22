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
	
	@Override
	public List<Movimientos> reporteMovimientos(LocalDateTime from, LocalDateTime to) {
		return reporteRepo.reporteEstadoCuenta(from, to);
	}

	@Override
	public Movimientos registrar(Movimientos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimientos modificar(Movimientos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimientos editar(Movimientos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimientos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimientos listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
