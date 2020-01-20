package ai.aei.response;


import ai.aei.model.Emotion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response to the aEi.ai emotion queries.
 *
 * @author rezaamini Created on 1/19/20
 */
@NoArgsConstructor
public class EmotionResponse extends AeiResponse {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private Emotion emotion;
}
