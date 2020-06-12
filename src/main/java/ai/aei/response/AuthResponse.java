package ai.aei.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Authentication response.
 *
 * @author aEi.ai Created on 1/5/20
 */
@Data
@NoArgsConstructor
public class AuthResponse {
    private String access_token;
    private String token_type;
    private long expires_in;
    private String scope;
}
