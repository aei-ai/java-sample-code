package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Observer user's impression of a another (target) user.
 *
 * @author rezaamini Created on 10/7/18
 */
@NoArgsConstructor
public class Impression {
    @Getter
    @Setter
    private String observerUserId;
    @Getter
    @Setter
    private String targetUserId;
    @Getter
    @Setter
    private Affect affect;
}
