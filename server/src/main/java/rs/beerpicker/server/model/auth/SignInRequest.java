package rs.beerpicker.server.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInRequest {
    private String username;
    private String password;
}
