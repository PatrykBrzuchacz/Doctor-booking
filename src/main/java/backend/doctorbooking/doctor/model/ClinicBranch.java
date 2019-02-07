package backend.doctorbooking.doctor.model;

import lombok.Data;

import javax.persistence.*;

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


}
