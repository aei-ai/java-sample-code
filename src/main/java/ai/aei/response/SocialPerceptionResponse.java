package ai.aei.response;

import ai.aei.model.SocialPerception;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai social-perception queries.
 *
 * @author aEi.ai Created on 1/19/20
 */
@Data
@NoArgsConstructor
public class SocialPerceptionResponse extends AeiResponse {
    private String userId;
    private SocialPerception socialPerception;
}
