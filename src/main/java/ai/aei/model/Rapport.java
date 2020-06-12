package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Rapport model.
 *
 * @author aEi.ai Created on 6/10/20
 */
@Data
@NoArgsConstructor
public class Rapport {
    private List<NonverbalBehavior> nonverbalBehaviors = new ArrayList<>();
}
