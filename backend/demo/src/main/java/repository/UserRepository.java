package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar usuário por username
    Optional<User> findByUsername(String username);

    // Adicionar mais consultas, como por exemplo:
    // List<User> findByLevel(String level);

    // Você também pode criar consultas personalizadas, como esta:
    // @Query("SELECT u FROM User u WHERE u.username = :username")
    // Optional<User> findUserByUsername(@Param("username") String username);
}
