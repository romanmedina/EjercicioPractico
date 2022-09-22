package pe.com.nttdata.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.entity.Cuenta;
import pe.com.nttdata.service.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {

	@Autowired
	CuentaService cuentaService;
	
	@GetMapping
	public ResponseEntity<List<Cuenta>> getAll(){
		List<Cuenta> lista = cuentaService.listar();
		return new ResponseEntity<List<Cuenta>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cuenta> getById(@PathVariable Integer id){
		Cuenta cu = cuentaService.listarPorId(id);
		return new ResponseEntity<Cuenta>(cu, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cuenta> create(@RequestBody Cuenta cuenta){
		Cuenta cu = cuentaService.registrar(cuenta);
		return new ResponseEntity<Cuenta>(cu, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cuenta> modify(@RequestBody Cuenta cuenta){
		Cuenta cu = cuentaService.modificar(cuenta);
		return new ResponseEntity<Cuenta>(cu, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cuenta> delete(@PathVariable Integer id){
		cuentaService.eliminar(id);
		return new ResponseEntity<Cuenta>(HttpStatus.NO_CONTENT);
	}
}
