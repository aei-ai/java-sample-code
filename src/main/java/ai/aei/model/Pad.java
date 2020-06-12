package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pleasure-Arousal-Dominance model.
 *
 * @author aEi.ai Created on 7/17/18
 */
@Data
@NoArgsConstructor
public class Pad {
    private double pleasure;
    private double arousal;
    private double dominance;
}
