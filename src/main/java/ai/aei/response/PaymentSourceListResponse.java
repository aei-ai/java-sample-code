package ai.aei.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai payment-source-list queries.
 *
 * @author aEi.ai Created on 1/6/20
 */
@Data
@NoArgsConstructor
public class PaymentSourceListResponse extends AeiResponse {
    private List<String> paymentSources = new ArrayList<>();
}
