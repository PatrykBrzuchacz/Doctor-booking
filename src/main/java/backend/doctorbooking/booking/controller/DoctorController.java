package backend.doctorbooking.booking.controller;

import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PutMapping("/clinics/{id}/branches/{id2}/addDoctor")
    public ResponseEntity<?> addDoctorToBranch(@PathVariable("id2") Long branch_id){
        doctorService.addClinicBranchToDoctor(branch_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/doctor/addExamination")
    public ResponseEntity<Long> addExaminationToDoc(@RequestBody Long examination_id){
        doctorService.addExaminationToDoc(examination_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}