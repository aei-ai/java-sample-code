package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * User model.
 *
 * @author aEi.ai Created on 7/24/18
 */
@Data
@NoArgsConstructor
public class User {
    private String userId;
    private Affect affect;
    private SocialPerception socialPerception;
    private List<Empathy> empathies = new ArrayList<>();
}
