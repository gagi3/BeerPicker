package rs.beerpicker.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rs.beerpicker.server.model.auth.*;
import rs.beerpicker.server.repository.RoleRepository;
import rs.beerpicker.server.repository.UserRepository;
import rs.beerpicker.server.security.JWTProvider;
import rs.beerpicker.server.service.abstraction.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JWTProvider provider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(SignUpRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userRepository.existsByUsername(request.getUsername())) {
            return null;
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setCredentialsExpired(false);
        user.setEnabled(true);
        Role role = new Role();
        role.setName(RoleName.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public JWTResponse login(SignInRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        if (user.getAccountExpired() || user.getAccountLocked() || user.getCredentialsExpired() || !user.getEnabled()) {
            return null;
        }
        return new JWTResponse(token, user.getUsername(), user.getAuthorities());
    }

    @Override
    public User update(User user) {
        User updated = findOne(user.getId());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        updated.setRoles(user.getRoles());
        updated.setEnabled(user.getEnabled());
        updated.setCredentialsExpired(user.getCredentialsExpired());
        updated.setAccountLocked(user.getAccountLocked());
        updated.setAccountExpired(user.getAccountExpired());
        updated.setLastName(user.getLastName());
        updated.setFirstName(user.getFirstName());
        updated.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(updated);
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
