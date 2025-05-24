package cz.upce.fei.nnpiacv.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RosterId implements Serializable {
    private Long eventId;
    private Long racerId;
}
