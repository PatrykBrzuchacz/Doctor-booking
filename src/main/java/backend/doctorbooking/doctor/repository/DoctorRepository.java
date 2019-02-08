package backend.doctorbooking.doctor.repository;

import backend.doctorbooking.common.security.model.User;
import backend.doctorbooking.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "doctors", path = "doctors")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DOCTOR')")
    List<Doctor> findAll();

    Doctor findDoctorByUserDoctor(User user);
}
