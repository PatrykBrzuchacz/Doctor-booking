package backend.doctorbooking.booking.model;

import backend.doctorbooking.booking.model.clinic.Clinic;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.common.security.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @OneToMany(mappedBy = "booking")
   // private List<ReservationRequest> reservationRequests = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userDoctor;

    @ManyToOne
    @JoinColumn(name = "clinic_branch_id")
    private ClinicBranch clinicBranch;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clinic> clinics = new ArrayList<>();

}