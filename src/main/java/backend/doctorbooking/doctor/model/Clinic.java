package backend.doctorbooking.doctor.model;

import backend.doctorbooking.common.security.model.User;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Clinic {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;

    @Column(name="house_number")
    private int houseNumber;

    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClinicBranch> clinicBranches = new ArrayList<>();




}

