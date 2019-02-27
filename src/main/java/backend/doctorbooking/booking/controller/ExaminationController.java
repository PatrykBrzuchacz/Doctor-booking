package backend.doctorbooking.booking.controller;

import backend.doctorbooking.booking.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;

@RepositoryRestController
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;


}

