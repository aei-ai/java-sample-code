package ai.aei.response;

import ai.aei.model.Interaction;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai interaction queries.
 *
 * @author aEi.ai Created on 1/5/20
 */
@Data
@NoArgsConstructor
public class InteractionResponse extends AeiResponse {
    private Interaction interaction;
}
