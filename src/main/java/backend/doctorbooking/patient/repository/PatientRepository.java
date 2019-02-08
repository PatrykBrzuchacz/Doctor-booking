package backend.doctorbooking.patient.repository;

import backend.doctorbooking.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
