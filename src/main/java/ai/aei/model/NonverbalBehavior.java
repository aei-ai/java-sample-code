package ai.aei.model;

import com.sun.istack.internal.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Nonverbal behavior model.
 *
 * @author aEi.ai Created on 6/10/20
 */
@Data
@NoArgsConstructor
public class NonverbalBehavior {
    private String name;
    @Nullable
    private Double intensity;
    @Nullable
    private Double duration;
    @Nullable
    private Integer start;
    @Nullable
    private Integer end;
    @Nullable
    private String side;
}
