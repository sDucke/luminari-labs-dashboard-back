package space.luminari_labs.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.luminari_labs.dashboard.entity.Usuario;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findAllByIdEquals(Long id);

    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}
