package backend.doctorbooking.doctor.repository;

import backend.doctorbooking.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "doctors", path = "doctors")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
