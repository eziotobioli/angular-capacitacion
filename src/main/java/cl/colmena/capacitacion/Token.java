package cl.colmena.capacitacion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    public Token()
    {
        super();
    }

    public Token(String sub, String name, Integer iat) {
        this.sub = sub;
        this.name = name;
        this.iat = iat;
    }

    String sub;
    String name;
    Integer iat;

}
