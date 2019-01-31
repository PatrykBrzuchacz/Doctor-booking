package backend.doctorbooking.common.controller;

import backend.doctorbooking.common.security.model.UserCredentials;
import backend.doctorbooking.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/users/signupPatient")
    public ResponseEntity<?> savePatient(@RequestBody UserCredentials userCredentials){
        userService.registerPatient(userCredentials);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value="/users/signupDoctor")
    public ResponseEntity<?> saveDoctor(@RequestBody UserCredentials userCredentials){
        userService.registerDoctor(userCredentials);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
