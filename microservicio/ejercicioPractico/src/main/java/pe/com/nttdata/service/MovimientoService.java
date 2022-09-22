package pe.com.nttdata.service;

import pe.com.nttdata.entity.Movimientos;

public interface MovimientoService extends ICRUD<Movimientos, Integer>{

	Movimientos movimientoDeposito(Movimientos movimiento);
	Movimientos movimientoRetiro(Movimientos movimiento);
}
