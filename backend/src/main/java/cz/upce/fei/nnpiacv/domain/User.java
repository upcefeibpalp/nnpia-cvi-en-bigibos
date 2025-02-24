package cz.upce.fei.nnpiacv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="app_user")
public class User {
    @Id
    private long id;
    private String email;
    private String password;

    public User() {

    }
}
