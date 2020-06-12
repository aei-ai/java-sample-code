package ai.aei.response;

import ai.aei.model.Personality;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai personality queries.
 *
 * @author aEi.ai Created on 1/19/20
 */
@Data
@NoArgsConstructor
public class PersonalityResponse extends AeiResponse {
    private String userId;
    private Personality personality;
}
