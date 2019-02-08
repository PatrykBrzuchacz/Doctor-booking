package backend.doctorbooking.doctor.model;

import backend.doctorbooking.common.security.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

  //  @OneToMany(mappedBy = "doctor")
   // private List<ReservationRequest> reservationRequests = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userDoctor;

    @ManyToOne
    @JoinColumn(name = "clinic_branch_id")
    private ClinicBranch clinicBranch;
}
