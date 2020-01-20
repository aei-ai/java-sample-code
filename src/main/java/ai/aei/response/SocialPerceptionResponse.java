package ai.aei.response;

import ai.aei.model.SocialPerception;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai social-perception queries.
 *
 * @author rezaamini Created on 1/19/20
 */
@NoArgsConstructor
public class SocialPerceptionResponse extends AeiResponse {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private SocialPerception socialPerception;
}
