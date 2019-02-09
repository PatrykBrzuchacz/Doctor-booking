package backend.doctorbooking.booking.service;

import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.booking.repository.DoctorRepository;
import backend.doctorbooking.booking.repository.clinic.ClinicBranchRepository;
import backend.doctorbooking.common.security.model.User;
import backend.doctorbooking.common.service.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private ClinicBranchRepository clinicBranchRepository;

    public Doctor addClinicBranchToDoctor(Long id){
        User loggedUser = userHelper.getLoggedUser();
        Doctor doctor = doctorRepository.findDoctorByUserDoctor(loggedUser);
        doctor.setClinicBranch(clinicBranchRepository.findClinicBranchById(id));
        return doctorRepository.save(doctor);
    }


}
