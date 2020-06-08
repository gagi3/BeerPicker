package rs.beerpicker.server.service.abstraction;

import rs.beerpicker.server.model.auth.JWTResponse;
import rs.beerpicker.server.model.auth.SignInRequest;
import rs.beerpicker.server.model.auth.SignUpRequest;
import rs.beerpicker.server.model.auth.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User findByUsername(String username);

    User create(SignUpRequest request);

    JWTResponse login(SignInRequest request);

    User update(User user);

    Boolean delete(Long id);
}
