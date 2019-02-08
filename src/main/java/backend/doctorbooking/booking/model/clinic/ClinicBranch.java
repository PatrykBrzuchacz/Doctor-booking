package backend.doctorbooking.booking.model.clinic;

import backend.doctorbooking.booking.model.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;


    @OneToMany(mappedBy = "clinicBranch")
    private List<Doctor> doctors = new ArrayList<>();
}
