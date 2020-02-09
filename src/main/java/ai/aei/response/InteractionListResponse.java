package ai.aei.response;

import ai.aei.model.Interaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai interaction-list queries.
 *
 * @author rezaamini Created on 2/8/20
 */
@NoArgsConstructor
public class InteractionListResponse extends AeiResponse {

    @Getter
    @Setter
    private List<Interaction> interactions = new ArrayList<>();
}
