package backend.doctorbooking.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examinationName;

    @ManyToMany(mappedBy = "examinations")
    private List<Doctor> doctors = new ArrayList<>();

}
