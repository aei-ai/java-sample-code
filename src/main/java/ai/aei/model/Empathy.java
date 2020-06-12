package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Empathy model.
 *
 * @author aEi.ai Created on 6/10/20
 */
@Data
@NoArgsConstructor
public class Empathy {
    private String targetUserId;
    private Affect affect;
}
