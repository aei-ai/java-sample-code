package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Emotion model.
 *
 * @author aEi.ai Created on 7/17/18
 */
@Data
@NoArgsConstructor
public class Emotion {
    private Pad pad;
    private String emotionName;
}
