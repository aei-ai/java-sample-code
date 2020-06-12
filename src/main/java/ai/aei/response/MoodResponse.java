package ai.aei.response;

import ai.aei.model.Mood;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai mood queries.
 *
 * @author aEi.ai Created on 1/19/20
 */
@Data
@NoArgsConstructor
public class MoodResponse extends AeiResponse {
    private String userId;
    private Mood mood;
}
