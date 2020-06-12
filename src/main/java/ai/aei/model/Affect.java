package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Affect model.
 *
 * @author aEi.ai Created on 7/17/18
 */
@Data
@NoArgsConstructor
public class Affect {
    private String affectId;
    private Emotion emotion;
    private Mood mood;
    private Personality personality;
    private Satisfaction satisfaction;
}
