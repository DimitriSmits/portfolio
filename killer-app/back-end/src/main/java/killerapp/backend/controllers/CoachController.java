package killerapp.backend.controllers;

import killerapp.backend.enitities.Coach;
import killerapp.backend.enitities.Lesson;
import killerapp.backend.enitities.Request;
import killerapp.backend.enitities.User;
import killerapp.backend.models.*;
import killerapp.backend.repositories.CoachRepo;
import killerapp.backend.repositories.RequestRepo;
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
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RequestRepo requestRepo;
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
    @PutMapping(path = "/")
    public ResponseEntity<?> editCoach(@RequestBody CoachEditModel coachEditModel){
        System.out.println("Edit profile started");
        Coach coach = coachRepo.findById(coachEditModel.getCoachId()).get();
        System.out.println("Found request");
        coach.setUserName(coachEditModel.getUserName());
        coach.setIntro(coachEditModel.getIntro());
        coach.setLolname(coachEditModel.getLolname());


        coachRepo.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCoach(@RequestBody CoachCreateModel coachCreateModel){
        System.out.println(coachCreateModel.getUserName()+"   "+coachCreateModel.getPassword());
        Coach coach = coachRepo.findByUserName(coachCreateModel.getUserName());
        String password = hash(coachCreateModel.getPassword(),stringToByte(coach.getSalt()));

        if(coach.getPassword().equals(password)){
            System.out.println("WACHTWOORD KLOPT");
            coach.setPassword("");
            coach.setSalt("");
            System.out.println(coach.getCoachId()+ "  "+ coach.getUserName()+"   "+coach.getLolname());

            return new ResponseEntity<>(coach, HttpStatus.CREATED);
        }
        else{
            //wachtwoord klopt
            System.out.println("WACHTWOORD KLOPT NIET");
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createCoach(@RequestBody CoachCreateModel coachCreateModel) {

        if (coachCreateModel.getUserName() == null || coachCreateModel.getPassword() == null||coachCreateModel.getIntro()==null||coachCreateModel.getLolname()==null) {
            System.out.println(coachCreateModel.getUserName()+"    :    "+coachCreateModel.getPassword());
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        saltG = createsalt();
        String salt = bytetoString(saltG);
        byte[] bytedsalt = stringToByte(salt);
        String finalsalt = bytetoString(bytedsalt);
        coachCreateModel.setSalt(finalsalt);
        String generatedHashPassword = hash(coachCreateModel.getPassword(),stringToByte(finalsalt));
        System.out.println("SALTTT: "+finalsalt);

        Coach coach = new Coach(coachCreateModel.getUserName(), generatedHashPassword,coachCreateModel.getIntro(),coachCreateModel.getLolname(),coachCreateModel.getSalt());
        coachRepo.save(coach);
        String password = hash(coachCreateModel.getPassword(),stringToByte(finalsalt));
        if(password.equals(generatedHashPassword)){
            System.out.println("HIER KLOPT HET NOG WEL");
        }
        coach.setSalt(null);
        coach.setPassword(null);
        return new ResponseEntity<>(coach, HttpStatus.CREATED);
    }
    @PostMapping("/request")
    public ResponseEntity<?> createRequest(@RequestBody RequestCreateModel requestCreateModel) {

        System.out.println("JAJAJAJAJAJA?");

        if (requestCreateModel.getUserId()==null || requestCreateModel.getCoachId()==null ||
                requestCreateModel.getQuestion()==null || requestCreateModel.getAccepted()==null){
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        User user = userRepo.findById(requestCreateModel.getUserId()).get();
        Coach coach = coachRepo.findById(requestCreateModel.getCoachId()).get();
        System.out.println(user.getUserId() + "        IDS     "+ coach.getCoachId());

        Request request = new Request(user, coach,requestCreateModel.getQuestion(),requestCreateModel.getAccepted());
        requestRepo.save(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
    public String hash(String passwordToHash, byte[] salt){
        String generatedPassword = null;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            md.update(salt);
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
        saltG = new byte[20];
        random.nextBytes(saltG);
        String saltString = bytetoString(saltG);
        saltG = stringToByte(saltString);

        return saltG;
    }
    public String bytetoString(byte[] input) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
    }
    public byte[] stringToByte(String input) {
        if (org.apache.commons.codec.binary.Base64.isBase64(input)) {
            return org.apache.commons.codec.binary.Base64.decodeBase64(input);

        } else {
            return org.apache.commons.codec.binary.Base64.encodeBase64(input.getBytes());
        }
    }
}
