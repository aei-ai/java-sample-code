package ai.aei.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai API-call queries, such as getting number of queries.
 *
 * @author rezaamini Created on 1/6/20
 */
@NoArgsConstructor
public class ApiCallResponse extends AeiResponse {
    @Getter
    @Setter
    private long queries;
}
