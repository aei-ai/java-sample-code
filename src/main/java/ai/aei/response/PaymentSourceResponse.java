package ai.aei.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai payment-source queries.
 *
 * @author aEi.ai Created on 1/6/20
 */
@Data
@NoArgsConstructor
public class PaymentSourceResponse extends AeiResponse {
    private String paymentSource;
}
