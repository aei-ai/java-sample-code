package ai.aei.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai subscription queries.
 *
 * @author aEi.ai Created on 1/6/20
 */
@Data
@NoArgsConstructor
public class SubscriptionResponse extends AeiResponse {
    private String subscription; // subscription as JSON string
}
