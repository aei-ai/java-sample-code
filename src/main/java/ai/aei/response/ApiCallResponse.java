package ai.aei.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai API-call queries, such as getting number of queries.
 *
 * @author aEi.ai Created on 1/6/20
 */
@Data
@NoArgsConstructor
public class ApiCallResponse extends AeiResponse {
    private long queries;
}
