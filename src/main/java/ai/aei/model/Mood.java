package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mood model.
 *
 * @author rezaamini Created on 7/19/18
 */
@NoArgsConstructor
public class Mood {
    @Getter
    @Setter
    private Pad pad;
    @Getter
    @Setter
    private String moodName;
}
