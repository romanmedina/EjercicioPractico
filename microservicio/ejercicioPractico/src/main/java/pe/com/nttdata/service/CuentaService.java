package pe.com.nttdata.service;

import pe.com.nttdata.entity.Cuenta;

public interface CuentaService extends ICRUD<Cuenta, Integer>{

	Cuenta actualizarSaldo(Cuenta cuenta, Double saldoTotal);
}
