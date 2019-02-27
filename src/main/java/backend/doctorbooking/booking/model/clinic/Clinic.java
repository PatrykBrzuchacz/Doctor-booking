package backend.doctorbooking.booking.model.clinic;

import backend.doctorbooking.booking.model.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String name;
    private int houseNumber;

    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor owner;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClinicBranch> clinicBranches = new ArrayList<>();




}

