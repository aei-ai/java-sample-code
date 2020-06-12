package ai.aei.response;

import ai.aei.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai user-list queries.
 *
 * @author aEi.ai Created on 1/6/20
 */
@Data
@NoArgsConstructor
public class UserListResponse extends AeiResponse {
    private List<User> users = new ArrayList<>();
}
