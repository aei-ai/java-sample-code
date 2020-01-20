package ai.aei.response;

import ai.aei.model.Satisfaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai satisfaction queries.
 *
 * @author rezaamini Created on 1/19/20
 */
@NoArgsConstructor
public class SatisfactionResponse extends AeiResponse {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private Satisfaction satisfaction;
}
