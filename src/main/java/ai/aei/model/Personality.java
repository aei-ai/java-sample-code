package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Personality model.
 *
 * @author aEi.ai Created on 7/19/18
 */
@Data
@NoArgsConstructor
public class Personality {
    private Pad pad;
    private BigFive bigFive;
}
