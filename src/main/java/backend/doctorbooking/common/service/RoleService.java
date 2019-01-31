package backend.doctorbooking.common.service;

import backend.doctorbooking.common.repository.RoleRepository;
import backend.doctorbooking.common.security.model.Role;
import backend.doctorbooking.common.security.model.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getPatientRole(){
        return roleRepository.findByName(RoleName.ROLE_PATIENT.name());
    }

    public Role getDoctorRole(){
        return roleRepository.findByName(RoleName.ROLE_DOCTOR.name());
    }

}
