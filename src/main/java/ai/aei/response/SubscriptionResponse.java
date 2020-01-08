package ai.aei.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai subscription queries.
 *
 * @author rezaamini Created on 1/6/20
 */
@NoArgsConstructor
public class SubscriptionResponse extends AeiResponse {
    @Getter
    @Setter
    private String subscription; // subscription as JSON string
}
