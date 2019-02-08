package backend.doctorbooking.doctor.service;

import backend.doctorbooking.doctor.model.Clinic;
import backend.doctorbooking.doctor.model.ClinicBranch;
import backend.doctorbooking.doctor.model.ClinicType;
import backend.doctorbooking.doctor.repository.ClinicBranchRepository;
import backend.doctorbooking.doctor.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicBranchService {

    @Autowired
    private ClinicBranchRepository clinicBranchRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicBranch addBranch(ClinicType type, Long id){
        ClinicBranch clinicBranch = new ClinicBranch();
        clinicBranch.setType(type);
        clinicBranch.setClinic(clinicRepository.getById(id));

        return clinicBranchRepository.save(clinicBranch);
    }

}
