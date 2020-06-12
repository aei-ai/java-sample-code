package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Interaction model between users.
 *
 * @author aEi.ai Created on 8/12/18
 */
@Data
@NoArgsConstructor
public class Interaction {
    private String interactionId;
    private List<User> users = new ArrayList<>();
}
