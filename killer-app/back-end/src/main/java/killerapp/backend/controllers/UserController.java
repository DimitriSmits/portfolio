package killerapp.backend.controllers;

import killerapp.backend.enitities.Lesson;
import killerapp.backend.enitities.Stats;
import killerapp.backend.enitities.User;
import killerapp.backend.models.UserCreateModel;
import killerapp.backend.repositories.StatsRepo;
import killerapp.backend.repositories.UserRepo;
import killerapp.backend.service.RiotAPI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/user")

public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StatsRepo statsRepo;
    private byte[] saltG;
    private String salt;

    @GetMapping(path ="/{id}")
    public User one(@PathVariable Long id){

        System.out.println("Zoekt op dit ID: "+id.toString());
        User user = userRepo.findById(id).get();
        System.out.println("Salt:  "+user.getSalt()+"   "+saltG);

        return user;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserCreateModel userCreateModel){
        System.out.println(userCreateModel.getUserName()+"   "+userCreateModel.getPassword());
        User user = userRepo.findByUserName(userCreateModel.getUserName());
        String password = hash(userCreateModel.getPassword(),stringToByte(user.getSalt()));

        if(user.getPassword().equals(password)){
            System.out.println("WACHTWOORD KLOPT");
            user.setPassword("");
            user.setSalt("");
            System.out.println(user.getUserId()+ "  "+ user.getUserName()+"   "+user.getLolname());

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        else{
            //wachtwoord klopt
            System.out.println("WACHTWOORD KLOPT NIET");
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserCreateModel userCreateModel) {
        RiotAPI riotAPI = new RiotAPI();

        //Riot api aanroepen
        String sumid = riotAPI.getSummonerIDbyName(userCreateModel.getLolname());
        Stats stats =  riotAPI.getStatisticsSummonerID(sumid);


        if (userCreateModel.getUserName() == null || userCreateModel.getPassword() == null) {
            System.out.println(userCreateModel.getUserName()+"    :    "+userCreateModel.getPassword());
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        //create salt and create hash for password
        saltG = createsalt();
        String salt = bytetoString(saltG);
        byte[] bytedsalt = stringToByte(salt);
        String finalsalt = bytetoString(bytedsalt);
        userCreateModel.setSalt(finalsalt);
        String generatedHashPassword = hash(userCreateModel.getPassword(),stringToByte(finalsalt));
        System.out.println("SALTTT: "+finalsalt);

        User user = new User(userCreateModel.getUserName(), generatedHashPassword,userCreateModel.getLolname(),userCreateModel.getSalt());
        userRepo.save(user);
        String password = hash(userCreateModel.getPassword(),stringToByte(finalsalt));
        if(password.equals(generatedHashPassword)){
            System.out.println("HIER KLOPT HET NOG WEL");
        }
        //userRepo.flush();

        //Save stats in DB
        stats.setUser(user);
        statsRepo.save(stats);
        user.setSalt(null);
        user.setPassword(null);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /*@PostMapping("/login")
    public ResponseEntity<?> createUser(@RequestBody UserCreateModel userCreateModel) {
        RiotAPI riotAPI = new RiotAPI();

        //Riot api aanroepen
        String sumid = riotAPI.getSummonerIDbyName(userCreateModel.getLolname());
        Stats stats =  riotAPI.getStatisticsSummonerID(sumid);


        if (userCreateModel.getUserName() == null || userCreateModel.getPassword() == null) {
            System.out.println(userCreateModel.getUserName()+"    :    "+userCreateModel.getPassword());
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }



        String generatedHashPassword = hash(userCreateModel.getPassword(),saltG);
        if(generatedHashPassword==user.getpassword)
        System.out.println("SALTTTTTTTTTTTTTTTTTTTTTTTTTT: "+saltG);


        user.setSalt(null);
        user.setPassword(null);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }*/
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
            /*String s = bytetoString(saltG);
            System.out.println(s + "  DIT IS SSSSS");
            byte[] yikes = stringToByte(s);
            String a = bytetoString(yikes);
            System.out.println(a + "DIT IS AAAA");
            generatedPassword = generatedPassword + bytetoString(saltG);
            System.out.println(generatedPassword);
            System.out.println(generatedPassword.replace(bytetoString(saltG),""));*/
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
