package pe.com.nttdata.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import pe.com.nttdata.entity.Cuenta;
import pe.com.nttdata.entity.Movimientos;
import pe.com.nttdata.repository.ICuentaRepository;
import pe.com.nttdata.repository.IMovimientoRepository;
import pe.com.nttdata.service.CuentaService;
import pe.com.nttdata.service.MovimientoService;

@Log4j2
@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	IMovimientoRepository movimientoRepo;
	
	@Autowired
	ICuentaRepository cuentaRepos;

	@Autowired
	CuentaService cuentaService;
	
	@Override
	public Movimientos registrar(Movimientos obj) {
		return movimientoRepo.save(obj);
	}

	@Override
	public Movimientos modificar(Movimientos obj) {
		return movimientoRepo.save(obj);
	}

	@Override
	public List<Movimientos> listar() {
		return movimientoRepo.findAll();
	}

	@Override
	public Movimientos listarPorId(Integer id) {
		Optional<Movimientos> mo = movimientoRepo.findById(id);
		return mo.isPresent() ? mo.get() : new Movimientos();
	}

	@Override
	public boolean eliminar(Integer id) {
		movimientoRepo.deleteById(id);
		return true;
	}

	@Override
	public Movimientos editar(Movimientos obj) {
		return movimientoRepo.save(obj);
	}

	@Override
	public Movimientos movimientoDeposito(Movimientos movimiento) {

		Double saldoInicial = 0.00;
		Double saldoTotal = 0.00;
		LocalDateTime month = LocalDateTime.now();
		Cuenta cuenta = null;
		Optional<Cuenta> cuentaById = cuentaRepos.findById(movimiento.getCuenta().getIdCuenta());
		if(cuentaById.isEmpty()) {
			log.info("La cuenta no existe");
			return null;
		}else {
			cuenta = cuentaById.get();
			saldoInicial = cuenta.getSaldoInicial();
			saldoTotal = (saldoInicial + movimiento.getValor());
			movimiento.setSaldo(saldoTotal);
			movimiento.setFecha(month);
			cuentaService.actualizarSaldo(cuenta, saldoTotal);
			log.info("Se depositó correctamente");
			return movimientoRepo.save(movimiento);
		}
	}

	@Override
	public Movimientos movimientoRetiro(Movimientos movimiento) {
		
		Double saldoInicial = 0.00;
		Double saldoTotal = 0.00;
		LocalDateTime month = LocalDateTime.now();
		Cuenta cuenta = null;
		Optional<Cuenta> cuentaById = cuentaRepos.findById(movimiento.getCuenta().getIdCuenta());
		if(!cuentaById.isEmpty()) {
			cuenta = cuentaById.get();
			saldoInicial = cuenta.getSaldoInicial();
			if(saldoInicial > movimiento.getValor()) {
				saldoTotal = (saldoInicial - movimiento.getValor());
				movimiento.setSaldo(saldoTotal);
				movimiento.setFecha(month);
				cuentaService.actualizarSaldo(cuenta, saldoTotal);
				log.info("Se depositó correctamente");
				return movimientoRepo.save(movimiento);
			}else {
				log.info("FALLIDO: Saldo no disponible");
				return null;
			}
		}else {
			log.info("FALLIDO: La cuenta no existe");
			return null;
		}
	}
}
