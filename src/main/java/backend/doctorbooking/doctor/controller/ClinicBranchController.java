package backend.doctorbooking.doctor.controller;

import backend.doctorbooking.doctor.model.ClinicBranch;
import backend.doctorbooking.doctor.model.ClinicType;
import backend.doctorbooking.doctor.repository.ClinicRepository;
import backend.doctorbooking.doctor.service.ClinicBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

