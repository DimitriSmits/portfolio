package killerapp.backend.controllers;

import killerapp.backend.FakeData.LessonData;
import killerapp.backend.enitities.Lesson;
import killerapp.backend.models.LessonCreateModel;
import killerapp.backend.repositories.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/lessons")

public class LessonController {
    @Autowired
    private LessonRepo lessonRepo;
    @GetMapping(path = "/" )
    public Iterable<Lesson> lessons() {
        System.out.println("Haalt alle lessons op");
        return lessonRepo.findAll();

    }
    @GetMapping(path ="/{id}")
    public Lesson one(@PathVariable Long id){
        System.out.println("Zoekt op dit ID: "+id.toString());
        return lessonRepo.findById(id).get();
    }

    @PostMapping("/")
    public ResponseEntity<?> createLesson(@RequestBody LessonCreateModel lessonCreateModel) {



        if (lessonCreateModel.getTitle() == null || lessonCreateModel.getDescription() == null||lessonCreateModel.getVideoURL()==null) {
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        Lesson lesson = new Lesson(lessonCreateModel.getTitle(),lessonCreateModel.getDescription(),lessonCreateModel.getVideoURL());
        lessonRepo.save(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }
    /*@PostConstruct
    public void init() {
        System.out.println("FKJASDFHKJALDHDLKJAHDJKLADAJK");
        LessonData lessonData = new LessonData();
        for (Lesson lesson : lessonData.getLessons()){
            lessonRepo.save(lesson);
        }
    }*/
}
