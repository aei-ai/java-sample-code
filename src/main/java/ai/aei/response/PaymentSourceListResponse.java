package ai.aei.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Response to the aEi.ai payment-source-list queries.
 *
 * @author rezaamini Created on 1/6/20
 */
@NoArgsConstructor
public class PaymentSourceListResponse extends AeiResponse {
    @Getter
    @Setter
    private List<String> paymentSources = new ArrayList<>();
}
