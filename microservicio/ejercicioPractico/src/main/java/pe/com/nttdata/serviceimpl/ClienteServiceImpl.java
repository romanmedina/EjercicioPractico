package pe.com.nttdata.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.nttdata.entity.Cliente;
import pe.com.nttdata.repository.IClienteRepository;
import pe.com.nttdata.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	IClienteRepository clienteRepo;
	
	@Override
	public Cliente registrar(Cliente obj) {
		return clienteRepo.save(obj);
	}

	@Override
	public Cliente modificar(Cliente obj) {
		return clienteRepo.save(obj);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente listarPorId(Integer id) {
		Optional<Cliente> cli = clienteRepo.findById(id);
		return cli.isPresent() ? cli.get() : new Cliente();
	}

	@Override
	public boolean eliminar(Integer id) {
		clienteRepo.deleteById(id);
		return true;
	}

	@Override
	public Cliente editar(Cliente obj) {
		return clienteRepo.save(obj);
	}

}
