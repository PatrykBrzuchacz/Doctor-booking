package backend.doctorbooking.booking.model;

import backend.doctorbooking.booking.model.clinic.Clinic;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.common.security.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable( name= "doctor_branch",
            joinColumns = @JoinColumn(name="doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="branch_id", referencedColumnName = "id"))
    private List<ClinicBranch> clinicBranchs = new ArrayList<>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clinic> clinics = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "doctor_examination",
            joinColumns = @JoinColumn(name="doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="examination_id", referencedColumnName = "id"))
    private List<Examination> examinations = new ArrayList<>();

    public void addExamination(Examination examination){
        if (examination != null) {
            examinations.add(examination);
        }
    }

    public void addClinicBranchToDoc(ClinicBranch clinicBranch){
        if(clinicBranch != null){
            clinicBranchs.add(clinicBranch);
        }
    }
}
