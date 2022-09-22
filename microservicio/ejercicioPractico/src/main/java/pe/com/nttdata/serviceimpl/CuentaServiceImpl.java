package pe.com.nttdata.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nttdata.entity.Cuenta;
import pe.com.nttdata.repository.ICuentaRepository;
import pe.com.nttdata.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	ICuentaRepository cuentaRepo;
	
	@Override
	public Cuenta registrar(Cuenta obj) {
		return cuentaRepo.save(obj);
	}

	@Override
	public Cuenta modificar(Cuenta obj) {
		return cuentaRepo.save(obj);
	}

	@Override
	public List<Cuenta> listar() {
		return cuentaRepo.findAll();
	}

	@Override
	public Cuenta listarPorId(Integer id) {
		Optional<Cuenta> cu = cuentaRepo.findById(id);
		return cu.isPresent() ? cu.get() : new Cuenta();
	}

	@Override
	public boolean eliminar(Integer id) {
		cuentaRepo.deleteById(id);
		return true;
	}

	@Override
	public Cuenta editar(Cuenta obj) {
		return cuentaRepo.save(obj);
	}

	@Override
	public Cuenta actualizarSaldo(Cuenta cuenta, Double Saldo) {
		cuenta.setSaldoInicial(Saldo);
		return cuentaRepo.save(cuenta);
	}

}
