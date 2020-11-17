package killerapp.backend.controllers;

import killerapp.backend.enitities.Request;
import killerapp.backend.enitities.Stats;
import killerapp.backend.models.RequestEditModel;
import killerapp.backend.repositories.CoachRepo;
import killerapp.backend.repositories.RequestRepo;
import killerapp.backend.repositories.StatsRepo;
import killerapp.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/coachsessions")

public class SessionsController {
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private CoachRepo coachRepo;
    @Autowired
    private UserRepo userRepo;



    @GetMapping(path ="/c/{id}")
    public Iterable<Request> requestsCoach(@PathVariable Long id) {
        System.out.println("Haalt alle requests op");
        return requestRepo.findAllByCoachAndAccepted(coachRepo.findById(id).get(),false);

    }
    @GetMapping(path ="/ct/{id}")
    public Iterable<Request> sessionsCoach(@PathVariable Long id) {
        System.out.println("Haalt alle requests op");
        return requestRepo.findAllByCoachAndAccepted(coachRepo.findById(id).get(),true);

    }
    @GetMapping(path ="/u/{id}")
    public Iterable<Request> requestsUser(@PathVariable Long id) {
        System.out.println("Haalt alle requests op");
        return requestRepo.findAllByUserAndAccepted(userRepo.findById(id).get(),true);

    }
    @PutMapping(path = "/")
    public ResponseEntity<?> editProfile(@RequestBody RequestEditModel requestEditModel){
        System.out.println("Edit profile started");
        Request request = requestRepo.findById(requestEditModel.getId()).get();
        System.out.println("Found request");
        request.setAccepted(requestEditModel.getAccepted());

        requestRepo.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}