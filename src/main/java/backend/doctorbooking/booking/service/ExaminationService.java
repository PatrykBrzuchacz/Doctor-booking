package backend.doctorbooking.booking.service;

import backend.doctorbooking.booking.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

}
