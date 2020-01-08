package ai.aei.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Authentication response.
 *
 * @author rezaamini Created on 1/5/20
 */
@NoArgsConstructor
public class AuthResponse {
    @Getter
    @Setter
    private String access_token;
    @Getter
    @Setter
    private String token_type;
    @Getter
    @Setter
    private long expires_in;
    @Getter
    @Setter
    private String scope;
}
