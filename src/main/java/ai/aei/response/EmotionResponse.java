package ai.aei.response;


import ai.aei.model.Emotion;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response to the aEi.ai emotion queries.
 *
 * @author aEi.ai Created on 1/19/20
 */
@Data
@NoArgsConstructor
public class EmotionResponse extends AeiResponse {
    private String userId;
    private Emotion emotion;
}
