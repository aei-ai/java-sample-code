package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Satisfaction model.
 *
 * @author rezaamini Created on 7/19/18
 */
@NoArgsConstructor
public class Satisfaction implements Serializable {
    @Getter
    @Setter
    private double score;
}
