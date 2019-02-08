package backend.doctorbooking.doctor.controller;

import backend.doctorbooking.doctor.model.Clinic;
import backend.doctorbooking.doctor.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestController
@RequestMapping("/api/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/addClinic")
    public ResponseEntity<Clinic> addClinic(@RequestBody Clinic clinic){
        clinicService.addClinic(clinic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
