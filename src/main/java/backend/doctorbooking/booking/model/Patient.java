package backend.doctorbooking.booking.model;

import backend.doctorbooking.common.security.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userPatient;

}
