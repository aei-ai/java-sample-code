package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Pleasure-Arousal-Dominance model.
 *
 * @author rezaamini Created on 7/17/18
 */
@NoArgsConstructor
public class Pad {
    @Getter
    @Setter
    private double pleasure;
    @Getter
    @Setter
    private double arousal;
    @Getter
    @Setter
    private double dominance;
}
