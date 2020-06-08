package rs.beerpicker.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.beerpicker.server.model.auth.Role;
import rs.beerpicker.server.model.auth.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByRolesContaining(Role role);
}
