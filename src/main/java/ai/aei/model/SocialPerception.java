package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * A user's social perception model.
 *
 * @author aEi.ai Created on 10/11/18
 */
@Data
@NoArgsConstructor
public class SocialPerception {
    private List<Impression> impressions = new ArrayList<>();
}
