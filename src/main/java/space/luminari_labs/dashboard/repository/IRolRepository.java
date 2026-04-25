package space.luminari_labs.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.luminari_labs.dashboard.entity.Rol;

import java.util.Optional;

public interface IRolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}
