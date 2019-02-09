package backend.doctorbooking.booking.controller;

import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/api/clinics")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PutMapping("/{id}/branches/{id2}/addDoctor")
    public ResponseEntity<?> addDoctorToBranch(@PathVariable("id2") Long idBranch){
        doctorService.addClinicBranchToDoctor(idBranch);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
