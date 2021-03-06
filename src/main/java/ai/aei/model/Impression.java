package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Observer user's impression of a another (target) user.
 *
 * @author aEi.ai Created on 10/7/18
 */
@Data
@NoArgsConstructor
public class Impression {
    private String observerUserId;
    private String targetUserId;
    private Affect affect;
}
