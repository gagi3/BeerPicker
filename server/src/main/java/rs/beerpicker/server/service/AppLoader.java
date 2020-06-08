package rs.beerpicker.server.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import rs.beerpicker.server.model.auth.Role;
import rs.beerpicker.server.model.auth.RoleName;
import rs.beerpicker.server.model.auth.User;
import rs.beerpicker.server.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppLoader implements ApplicationRunner {
    private final UserRepository userRepository;

    public AppLoader(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findAll().size() == 0) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            Role role = new Role();
            role.setName(RoleName.ROLE_ADMIN);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            User user = new User();
            user.setUsername("admin@admin.com");
            user.setPassword(encoder.encode("admin"));
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setAccountExpired(false);
            user.setAccountLocked(false);
            user.setCredentialsExpired(false);
            user.setEnabled(true);
            user.setRoles(roles);
            userRepository.save(user);
            System.out.println("Admin created!");
        }
    }
}
