package killerapp.backend.controllers;

import killerapp.backend.enitities.User;
import killerapp.backend.models.UserCreateModel;
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
@RequestMapping(value="/user")

public class UserController {
    @Autowired
    private UserRepo userRepo;
    private byte[] saltG;


    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserCreateModel userCreateModel) {
        if (userCreateModel.getUserName() == null || userCreateModel.getPassword() == null) {
            System.out.println(userCreateModel.getUserName()+"    :    "+userCreateModel.getPassword());
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        //create salt and create has for password
        saltG = createsalt();
        userCreateModel.setSalt(saltG);
        String generatedHashPassword = hash(userCreateModel.getPassword(),saltG);

        User user = new User(userCreateModel.getUserName(), generatedHashPassword,userCreateModel.getSalt());
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
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
