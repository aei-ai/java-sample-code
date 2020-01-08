package ai.aei.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai payment-source queries.
 *
 * @author rezaamini Created on 1/6/20
 */
@NoArgsConstructor
public class PaymentSourceResponse extends AeiResponse {
    @Getter
    @Setter
    private String paymentSource;
}
