package ai.aei.response;

import ai.aei.model.Interaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai interaction queries.
 *
 * @author rezaamini Created on 1/5/20
 */
@NoArgsConstructor
public class InteractionResponse extends AeiResponse {
    @Getter
    @Setter
    private Interaction interaction;
}
