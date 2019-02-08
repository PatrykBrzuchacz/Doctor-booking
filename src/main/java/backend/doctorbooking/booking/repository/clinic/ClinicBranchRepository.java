package backend.doctorbooking.booking.repository.clinic;


import backend.doctorbooking.booking.model.clinic.Clinic;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource
public interface ClinicBranchRepository extends JpaRepository<ClinicBranch,Long> {

    List<ClinicBranch> findAllByClinicId(Long byId);

    ClinicBranch findClinicBranchById(Long id);
}

