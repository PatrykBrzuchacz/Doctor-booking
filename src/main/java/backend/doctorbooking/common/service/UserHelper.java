package backend.doctorbooking.common.service;

import backend.doctorbooking.common.repository.UserRepository;
import backend.doctorbooking.common.security.model.RoleName;
import backend.doctorbooking.common.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserHelper {

    @Autowired
    private UserRepository userRepository;

    public boolean isDoctor(Collection<? extends GrantedAuthority> authorities){
        return !authorities.isEmpty() && authorities.iterator().next().getAuthority().equals(RoleName.ROLE_DOCTOR.name());
    }

    public boolean isPatient(Collection<? extends GrantedAuthority> authorities){
        return !authorities.isEmpty() && authorities.iterator().next().getAuthority().equals(RoleName.ROLE_PATIENT.name());
    }

    public User getLoggedUser() {
        return userRepository.findByUsername(getLoggedUserUsername());
    }

    public String getLoggedUserUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null)
            return null;

        Object principal = authentication.getPrincipal();

        if (principal.getClass() == UserDetails.class)
            return ((UserDetails) principal).getUsername();

        if (principal.getClass() == String.class)
            return principal.toString();

        return null;
    }




}
