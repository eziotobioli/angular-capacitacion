package cl.colmena.capacitacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@RestController
@RequestMapping("auth")
public class HealthController {

    final static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @PostMapping("/login")
    public String login(@RequestParam Integer app, @RequestParam String username, @RequestParam String password){

        if (username.equals("11111111-1")){
            return TOKEN;
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Check user credentials");
        }
    }

    @PostMapping("/validate")
    public boolean validate(@RequestHeader("X-Auth-Token") String token) throws JsonProcessingException {


        String[] pieces = token.split("\\.");
        String b64payload = pieces[1];

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String(Base64.getDecoder().decode(b64payload), StandardCharsets.UTF_8);
        System.out.println(jsonString);
        Token decryptedToken = mapper.readValue(jsonString, Token.class);

        return decryptedToken.iat.equals(1516239022);
    }
}
