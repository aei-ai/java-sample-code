package ai.aei.response;

import ai.aei.model.Empathy;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai emotion queries.
 *
 * @author aEi.ai Created on 6/10/20
 */
@Data
@NoArgsConstructor
public class EmpathyResponse extends AeiResponse {
    private String userId;
    private List<Empathy> empathies = new ArrayList<>();
}
