package ai.aei.response;

import ai.aei.model.Personality;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai personality queries.
 *
 * @author rezaamini Created on 1/19/20
 */
@NoArgsConstructor
public class PersonalityResponse extends AeiResponse {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private Personality personality;
}
