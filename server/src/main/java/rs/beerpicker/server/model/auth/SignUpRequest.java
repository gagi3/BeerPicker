package rs.beerpicker.server.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
