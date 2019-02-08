package backend.doctorbooking.booking.model;


import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.common.security.model.User;
import backend.doctorbooking.booking.model.clinic.Clinic;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ReservationRequest {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private User patient;

    @ManyToOne
    @JoinColumn(name="clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name="clinic_branch_id")
    private ClinicBranch clinicBranch;
}
