package pe.com.nttdata.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.nttdata.entity.Cliente;
import pe.com.nttdata.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		List<Cliente> lista = clienteService.listar();
		return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id){
		Cliente cli = clienteService.listarPorId(id);
		return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
		Cliente cli = clienteService.registrar(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modify(@RequestBody Cliente cliente){
		Cliente cli = clienteService.modificar(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.CREATED);
	}
	
	@PatchMapping
	public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
		Cliente cli = clienteService.editar(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id){
		clienteService.eliminar(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}
	
}
