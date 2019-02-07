package backend.doctorbooking.doctor.model;

import backend.doctorbooking.common.security.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ClinicBranch {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value=EnumType.STRING)
    private ClinicType type;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToMany
    @JoinTable(name = "doctors_On_Clinic_Branch",
        joinColumns = @JoinColumn(name="id_clinic_branch", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="id_doctor", referencedColumnName = "id"))
    private List<User> doctors = new ArrayList<>();
}
