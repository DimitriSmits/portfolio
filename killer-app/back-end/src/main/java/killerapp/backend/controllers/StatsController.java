package killerapp.backend.controllers;

import killerapp.backend.enitities.Stats;

import killerapp.backend.repositories.StatsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/stats")

public class StatsController {
    @Autowired
    private StatsRepo statsRepo;

    @GetMapping(path ="/{id}")
    public Stats one(@PathVariable Long id){
        System.out.println("Zoekt op dit ID: "+id.toString());
        return statsRepo.findById(id).get();
    }
}
