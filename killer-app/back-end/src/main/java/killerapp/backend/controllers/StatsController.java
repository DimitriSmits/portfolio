package killerapp.backend.controllers;

import killerapp.backend.enitities.Lesson;
import killerapp.backend.enitities.Stats;
import killerapp.backend.models.LessonCreateModel;
import killerapp.backend.repositories.LessonRepo;
import killerapp.backend.repositories.StatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/stats")

public class StatsController {
    @Autowired
    private StatsRepo statsRepo;
    /*@GetMapping(path = "/" )
    public Iterable<Stats> stats() {
        System.out.println("Haalt alle stats op");
        return statsRepo.findAll();

    }*/
    @GetMapping(path ="/{id}")
    public Stats one(@PathVariable Long id){
        System.out.println("Zoekt op dit ID: "+id.toString());
        return statsRepo.findById(id).get();
    }
}
