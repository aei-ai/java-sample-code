package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Big Five personality trait model.
 *
 * @author aEi.ai Created on 8/24/18
 */
@Data
@NoArgsConstructor
public class BigFive {
    private double openness;
    private double conscientiousness;
    private double extroversion;
    private double agreeableness;
    private double neuroticism;
}
