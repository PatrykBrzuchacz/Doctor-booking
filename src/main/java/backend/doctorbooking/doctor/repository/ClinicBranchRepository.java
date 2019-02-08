package backend.doctorbooking.doctor.repository;


import backend.doctorbooking.doctor.model.ClinicBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clinics", path = "clinics/branchs")
public interface ClinicBranchRepository extends JpaRepository<ClinicBranch,Long> {

}

