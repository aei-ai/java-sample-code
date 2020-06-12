package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Satisfaction model.
 *
 * @author aEi.ai Created on 7/19/18
 */
@Data
@NoArgsConstructor
public class Satisfaction implements Serializable {
    private double score;
}
