package cl.colmena.capacitacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("events")
public class MainController {

    @GetMapping("")
    public List<EventCard> getAll() {
        List<EventCard> events = new ArrayList<>();

        events.add(new EventCard(1,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London"));
        events.add(new EventCard(2,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London"));
        events.add(new EventCard(3,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London"));
        return events;
    }

    @GetMapping("/{id}")
    public EventCard getById(@PathVariable Integer id){

        if(id.equals(1)){
            return new EventCard(1,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London");
        }

        if(id.equals(2)){
            return new EventCard(2,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London");
        }

        if(id.equals(3)){
            return new EventCard(3,"Angular Connect", LocalDateTime.now().toString(), 1000.0, "1057 DT, London");
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " not found");
    }
}
