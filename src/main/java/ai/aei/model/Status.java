package ai.aei.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response status.
 *
 * @author aEi.ai Created on 1/5/20
 */
@Data
@NoArgsConstructor
public class Status {
    private int code;
    private String error;
    private String help;
}
