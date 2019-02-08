package backend.doctorbooking.doctor.repository;

import backend.doctorbooking.doctor.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clinics", path = "clinics")
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

}
