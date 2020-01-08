package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Emotion model.
 *
 * @author rezaamini Created on 7/17/18
 */
@NoArgsConstructor
public class Emotion {
    @Getter
    @Setter
    private Pad pad;
    @Getter
    @Setter
    private String emotionName;
}
