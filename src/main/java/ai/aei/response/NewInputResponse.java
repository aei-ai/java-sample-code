package ai.aei.response;

import ai.aei.model.Rapport;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to sending a new text input to the aEi.ai services.
 *
 * @author aEi.ai Created on 6/10/20
 */
@Data
@NoArgsConstructor
public class NewInputResponse extends AeiResponse {
    private Rapport rapport;
}
