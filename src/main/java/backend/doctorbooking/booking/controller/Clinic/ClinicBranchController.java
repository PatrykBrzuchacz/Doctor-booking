package backend.doctorbooking.booking.controller.Clinic;

import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.booking.repository.clinic.ClinicRepository;
import backend.doctorbooking.booking.service.clinic.ClinicBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RepositoryRestController
@RequestMapping("/api/clinics")
public class ClinicBranchController {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private ClinicBranchService clinicBranchService;

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/{id}/addBranch")
    public ResponseEntity<ClinicBranch> addBranch(@RequestBody ClinicBranch clinicBranch, @PathVariable("id") Long id){
        clinicBranchService.addBranch(clinicBranch.getType(),id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/{id}/branches")
    public ResponseEntity<List<ClinicBranch>> getBranchListByClinicId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clinicBranchService.getClinicBranchesByClinicId(id));
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/{id}/branches/{id2}")
    public ResponseEntity<ClinicBranch> getBranchByClinicId(@PathVariable("id2") Long id2){
        return ResponseEntity.ok(clinicBranchService.getClinicBranchById(id2));
    }

}

