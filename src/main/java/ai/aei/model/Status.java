package ai.aei.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response status.
 *
 * @author rezaamini Created on 1/5/20
 */
@NoArgsConstructor
public class Status {
    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String error;
    @Getter
    @Setter
    private String help;
}
