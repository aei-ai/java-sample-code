package ai.aei.response;

import ai.aei.model.Satisfaction;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai satisfaction queries.
 *
 * @author aEi.ai Created on 1/19/20
 */
@Data
@NoArgsConstructor
public class SatisfactionResponse extends AeiResponse {
    private String userId;
    private Satisfaction satisfaction;
}
