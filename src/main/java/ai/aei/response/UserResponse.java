package ai.aei.response;

import ai.aei.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai user queries.
 *
 * @author rezaamini Created on 1/5/20
 */
@NoArgsConstructor
public class UserResponse extends AeiResponse {
    @Getter
    @Setter
    private User user;
}
