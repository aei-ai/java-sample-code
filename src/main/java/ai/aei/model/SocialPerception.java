package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * A user's social perception model.
 *
 * @author rezaamini Created on 10/11/18
 */
@NoArgsConstructor
public class SocialPerception {
    @Getter
    @Setter
    private List<Impression> impressions = new ArrayList<>();
}
