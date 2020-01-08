package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Big Five personality trait model.
 *
 * @author rezaamini Created on 8/24/18
 */
@NoArgsConstructor
public class BigFive {
    @Getter
    @Setter
    private double openness;
    @Getter
    @Setter
    private double conscientiousness;
    @Getter
    @Setter
    private double extroversion;
    @Getter
    @Setter
    private double agreeableness;
    @Getter
    @Setter
    private double neuroticism;
}
