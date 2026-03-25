package space.luminari_labs.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.luminari_labs.dashboard.entity.Usuario;
import space.luminari_labs.dashboard.repository.UsuarioRepositorio;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public Usuario buscarPorId(Long id) {
        return repositorio.buscarPorUsuario(id);
    }
}
