package ai.aei.response;

import ai.aei.model.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An aEi.ai API response.
 *
 * @author aEi.ai Created on 1/5/20
 */
@Data
@NoArgsConstructor
public class AeiResponse {
    private Status status;
}
