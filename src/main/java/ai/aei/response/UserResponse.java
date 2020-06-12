package ai.aei.response;

import ai.aei.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai user queries.
 *
 * @author aEi.ai Created on 1/5/20
 */
@Data
@NoArgsConstructor
public class UserResponse extends AeiResponse {
    private User user;
}
