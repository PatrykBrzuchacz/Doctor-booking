package backend.doctorbooking.booking.service.clinic;

import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.booking.model.clinic.ClinicType;
import backend.doctorbooking.booking.repository.clinic.ClinicBranchRepository;
import backend.doctorbooking.booking.repository.clinic.ClinicRepository;
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
