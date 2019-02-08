package backend.doctorbooking.booking.repository.clinic;

import backend.doctorbooking.booking.model.clinic.Clinic;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clinics", path = "clinics")
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR','ROLE_PATIENT')")
    List<Clinic> findAll();

    @PreAuthorize("hasAnyRole('ROLE_DOCTOR','ROLE_PATIENT')")
    Clinic getById(Long id);
}
