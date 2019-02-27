package backend.doctorbooking.booking.repository;

import backend.doctorbooking.booking.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(collectionResourceRel = "examinations", path = "examinations")
public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    Examination findExaminationById(Long id);

}
