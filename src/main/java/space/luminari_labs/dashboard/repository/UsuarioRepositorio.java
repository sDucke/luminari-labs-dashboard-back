package space.luminari_labs.dashboard.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import space.luminari_labs.dashboard.entity.Usuario;

@Repository
public class UsuarioRepositorio {

    @Autowired
    private IUsuarioRepository repository;

    public Usuario buscarPorUsuario(Long id){
        return repository.findAllByIdEquals(id);
    }
}
