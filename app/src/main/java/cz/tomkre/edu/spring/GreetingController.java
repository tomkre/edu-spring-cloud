package cz.tomkre.edu.spring;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("api/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final Map<String, Greeting> repository = new TreeMap<>();

    private final GreetingService greetingService;

    @GetMapping
    public Iterable<Greeting> getAll() {
        return greetingService.getAll();
    }

    @GetMapping("{lang}")
    public Greeting getOne(@PathVariable String lang) {
        return greetingService.getOne(lang);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Greeting create(@Valid @RequestBody Greeting greeting) {
        return greetingService.create(greeting);
    }

}
