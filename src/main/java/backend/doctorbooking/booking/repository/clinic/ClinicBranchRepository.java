package backend.doctorbooking.booking.repository.clinic;


import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clinics", path = "clinics/branchs")
public interface ClinicBranchRepository extends JpaRepository<ClinicBranch,Long> {

}

