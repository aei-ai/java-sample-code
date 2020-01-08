package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Interaction model between users.
 *
 * @author rezaamini Created on 8/12/18
 */
@NoArgsConstructor
public class Interaction {
    @Getter
    @Setter
    private String interactionId;
    @Getter
    @Setter
    private List<User> users = new ArrayList<>();
}
