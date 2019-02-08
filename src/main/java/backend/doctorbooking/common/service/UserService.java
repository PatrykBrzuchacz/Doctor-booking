package backend.doctorbooking.common.service;

import backend.doctorbooking.common.exception.UsernameAlreadyExistsException;
import backend.doctorbooking.common.repository.UserRepository;
import backend.doctorbooking.common.security.model.Role;
import backend.doctorbooking.common.security.model.User;
import backend.doctorbooking.common.security.model.UserCredentials;
import backend.doctorbooking.booking.model.Doctor;
import backend.doctorbooking.booking.repository.DoctorRepository;
import backend.doctorbooking.booking.model.Patient;
import backend.doctorbooking.booking.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoles().getName()));

        return authorities;
    }

    public Patient savePatient(UserCredentials user, Role role) {
        Patient patient = new Patient();
        patient.setUserPatient(createUser(user,role));
       return patientRepository.save(patient);
    }

    public Doctor saveDoctor(UserCredentials user, Role role) {
       Doctor doctor = new Doctor();
        doctor.setUserDoctor(createUser(user,role));
        return doctorRepository.save(doctor);
    }

    public User createUser(UserCredentials user, Role role){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRoles(role);
        userRepository.save(newUser);
        return newUser;
    }

    private void checkUsername(String username){
        boolean usernameExists = userRepository.existsUserByUsername(username);

        if(usernameExists) throw new UsernameAlreadyExistsException();
    }

    public Patient registerPatient(UserCredentials user){
        checkUsername(user.getUsername());

        return savePatient(user,roleService.getPatientRole());
    }

    public Doctor registerDoctor(UserCredentials user){
        checkUsername(user.getUsername());

        return saveDoctor(user, roleService.getDoctorRole());
    }

}
