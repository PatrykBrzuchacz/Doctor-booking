package backend.doctorbooking.booking.controller;

import backend.doctorbooking.booking.model.Doctor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;

@RepositoryRestController
public class DoctorController {

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PutMapping("/api/clinics/{id}/branchs/{id2}")
    public ResponseEntity<Doctor> addDoctorToBranch(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
