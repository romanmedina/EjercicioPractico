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
import pe.com.nttdata.entity.Movimientos;
import pe.com.nttdata.service.MovimientoService;

@RestController
@RequestMapping("/api/v1/movimientos")
public class MovimientoController {

	@Autowired
	MovimientoService movimientoService;
	
	@GetMapping
	public ResponseEntity<List<Movimientos>> getAll(){
		List<Movimientos> lista = movimientoService.listar();
		return new ResponseEntity<List<Movimientos>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movimientos> getById(@PathVariable Integer id){
		Movimientos mov = movimientoService.listarPorId(id);
		return new ResponseEntity<Movimientos>(mov, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Movimientos> create(@RequestBody Movimientos movimientos){
		Movimientos mov = movimientoService.registrar(movimientos);
		return new ResponseEntity<Movimientos>(mov, HttpStatus.CREATED);
	}
	
	@PostMapping("/depositar")
	public ResponseEntity<Movimientos> depositarMovimiento(@RequestBody Movimientos movimientos){
		Movimientos mov = movimientoService.movimientoDeposito(movimientos);
		return new ResponseEntity<Movimientos>(mov, HttpStatus.CREATED);
	}
	
	@PostMapping("/retirar")
	public ResponseEntity<Movimientos> retirarMovimiento(@RequestBody Movimientos movimientos){
		Movimientos mov = movimientoService.movimientoRetiro(movimientos);
		return new ResponseEntity<Movimientos>(mov, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Movimientos> modify(@RequestBody Movimientos movimientos){
		Movimientos mov = movimientoService.modificar(movimientos);
		return new ResponseEntity<Movimientos>(mov, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Movimientos> delete(@PathVariable Integer id){
		movimientoService.eliminar(id);
		return new ResponseEntity<Movimientos>(HttpStatus.NO_CONTENT);
	}
}
