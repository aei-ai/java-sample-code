package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Personality model.
 *
 * @author rezaamini Created on 7/19/18
 */
@NoArgsConstructor
public class Personality {
    @Getter
    @Setter
    private Pad pad;
    @Getter
    @Setter
    private BigFive bigFive;
}
