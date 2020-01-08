package ai.aei.response;

import ai.aei.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai user-list queries.
 *
 * @author rezaamini Created on 1/6/20
 */
@NoArgsConstructor
public class UserListResponse extends AeiResponse {
    @Getter
    @Setter
    private List<User> users = new ArrayList<>();
}
