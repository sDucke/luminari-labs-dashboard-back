package space.luminari_labs.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.luminari_labs.dashboard.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findAllByIdEquals(Long id);

}
