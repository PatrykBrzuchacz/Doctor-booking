package backend.doctorbooking.booking.service.clinic;

import backend.doctorbooking.common.security.model.User;
import backend.doctorbooking.common.service.UserHelper;
import backend.doctorbooking.booking.model.clinic.Clinic;
import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.repository.clinic.ClinicRepository;
import backend.doctorbooking.booking.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserHelper userHelper;

    public Clinic addClinic(Clinic clinic){
    User loggedUser = userHelper.getLoggedUser();
    Doctor doctor = doctorRepository.findDoctorByUserDoctor(loggedUser);
    clinic.setOwner(doctor);
    return clinicRepository.save(clinic);
    }

}
