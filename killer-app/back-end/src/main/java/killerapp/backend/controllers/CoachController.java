package killerapp.backend.controllers;

import killerapp.backend.enitities.Coach;
import killerapp.backend.enitities.Lesson;
import killerapp.backend.enitities.User;
import killerapp.backend.models.CoachCreateModel;
import killerapp.backend.models.UserCreateModel;
import killerapp.backend.repositories.CoachRepo;
import killerapp.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/coaches")

public class CoachController {
    @Autowired
    private CoachRepo coachRepo;
    private byte[] saltG;

    @GetMapping(path = "/" )
    public Iterable<Coach> coaches() {
        System.out.println("Haalt alle coaches op");
        return coachRepo.findAll();

    }
    @GetMapping(path ="/{id}")
    public Coach one(@PathVariable Long id){
        System.out.println("Zoekt op dit ID: "+id.toString());
        return coachRepo.findById(id).get();
    }


    @PostMapping("/")
    public ResponseEntity<?> createCoach(@RequestBody CoachCreateModel coachCreateModel) {



        if (coachCreateModel.getUserName() == null || coachCreateModel.getPassword() == null||coachCreateModel.getIntro()==null||coachCreateModel.getLolname()==null) {
            System.out.println(coachCreateModel.getUserName()+"    :    "+coachCreateModel.getPassword());
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        //create salt and create hash for password
        saltG = createsalt();
        coachCreateModel.setSalt(saltG);
        String generatedHashPassword = hash(coachCreateModel.getPassword(),saltG);

        Coach coach = new Coach(coachCreateModel.getUserName(), generatedHashPassword,coachCreateModel.getIntro(),coachCreateModel.getLolname(),coachCreateModel.getSalt());
        coachRepo.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.CREATED);
    }
    public String hash(String passwordToHash, byte[] salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /*public boolean checkPassword(String hash, byte[] salt){
        String generatedHash = hash(hash, salt);
        return hashh.equals(generatedHash);
    }*/
    public byte[] createsalt(){
        SecureRandom random = new SecureRandom();
        saltG = new byte[16];
        random.nextBytes(saltG);
        return saltG;
    }
}
