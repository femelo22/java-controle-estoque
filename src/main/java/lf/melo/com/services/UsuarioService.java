package lf.melo.com.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lf.melo.com.entities.Usuario;
import lf.melo.com.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario create(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario findById(Long id) {
		return repository.findById(id).get();
	}
	
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	
	public void delete(Long id) {
		Usuario usuario = findById(id);
		repository.delete(usuario);
	}
	
	public Usuario update(Usuario usuario, Long id) {
		Usuario newUsuario = findById(id);
		
		BeanUtils.copyProperties(usuario, newUsuario);
		
		newUsuario.setId(id);
		
		return repository.save(newUsuario);
	}
	
}
