package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mood model.
 *
 * @author aEi.ai Created on 7/19/18
 */
@Data
@NoArgsConstructor
public class Mood {
    private Pad pad;
    private String moodName;
}
