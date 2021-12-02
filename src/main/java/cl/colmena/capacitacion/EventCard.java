package cl.colmena.capacitacion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventCard {

    public EventCard(Integer id, String title, String datetime, Double amount, String location) {
        this.id = id;
        this.title = title;
        this.datetime = datetime;
        this.amount = amount;
        this.location = location;
    }

    Integer id;
    String title;
    String datetime;
    Double amount;
    String location;

}
