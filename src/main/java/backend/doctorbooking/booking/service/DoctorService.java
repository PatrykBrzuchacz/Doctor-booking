package backend.doctorbooking.booking.service;

import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.model.Examination;
import backend.doctorbooking.booking.model.clinic.ClinicBranch;
import backend.doctorbooking.booking.repository.DoctorRepository;
import backend.doctorbooking.booking.repository.ExaminationRepository;
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

    @Autowired
    private ExaminationRepository examinationRepository;

    public Doctor addClinicBranchToDoctor(Long id){
        User loggedUser = userHelper.getLoggedUser();
        Doctor doctor = doctorRepository.findDoctorByUserDoctor(loggedUser);
        doctor.addClinicBranchToDoc(clinicBranchRepository.findClinicBranchById(id));
        return doctorRepository.save(doctor);
    }

    public Doctor addExaminationToDoc(Long id){
        User loggedUser = userHelper.getLoggedUser();
        Doctor doctor = doctorRepository.findDoctorByUserDoctor(loggedUser);
        Examination examination = examinationRepository.findExaminationById(id);
        System.out.println(examination.getExaminationName());
        doctor.addExamination(examination);
        return doctorRepository.save(doctor);
    }

}
