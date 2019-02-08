package backend.doctorbooking.booking.service;

import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.booking.repository.DoctorRepository;
import backend.doctorbooking.booking.repository.clinic.ClinicBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicBranchRepository clinicBranchRepository;



}
