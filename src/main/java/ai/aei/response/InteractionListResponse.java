package ai.aei.response;

import ai.aei.model.Interaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai interaction-list queries.
 *
 * @author aEi.ai Created on 2/8/20
 */
@Data
@NoArgsConstructor
public class InteractionListResponse extends AeiResponse {
    private List<Interaction> interactions = new ArrayList<>();
}
