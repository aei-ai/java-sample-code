package ai.aei.response;

import ai.aei.model.Mood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai mood queries.
 *
 * @author rezaamini Created on 1/19/20
 */
@NoArgsConstructor
public class MoodResponse extends AeiResponse {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private Mood mood;
}
