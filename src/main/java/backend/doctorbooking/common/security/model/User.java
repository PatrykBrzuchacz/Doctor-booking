package backend.doctorbooking.common.security.model;

import backend.doctorbooking.doctor.model.Clinic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private String username;

    @JsonIgnore
    @NonNull
    private String password;

    @JsonIgnore
    @ManyToOne
    @NonNull
    @JoinColumn(name="id_role")
    private Role roles;

    @OneToMany(mappedBy = "owner")
    private List<Clinic> clinics = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public User(Long id, String username, String password, Role roles){
        this.id=id;
        this.username=username;
        this.password=password;
        this.roles=roles;
    }
}
