package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Affect model.
 *
 * @author rezaamini Created on 7/17/18
 */
@NoArgsConstructor
public class Affect {
    @Getter
    @Setter
    private String affectId;
    @Getter
    @Setter
    private Emotion emotion;
    @Getter
    @Setter
    private Mood mood;
    @Getter
    @Setter
    private Personality personality;
    @Getter
    @Setter
    private Satisfaction satisfaction;
}
