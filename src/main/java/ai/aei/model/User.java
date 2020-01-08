package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User model.
 *
 * @author rezaamini Created on 7/24/18
 */
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private Affect affect;
    @Getter
    @Setter
    private SocialPerception socialPerception;
}
