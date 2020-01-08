package ai.aei.response;

import ai.aei.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * An aEi.ai API response.
 *
 * @author rezaamini Created on 1/5/20
 */
@NoArgsConstructor
public class AeiResponse {
    @Getter
    @Setter
    private Status status;
}
