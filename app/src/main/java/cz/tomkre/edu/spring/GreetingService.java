package cz.tomkre.edu.spring;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class GreetingService {

    private final Map<String, Greeting> repository = new TreeMap<>();

    public Iterable<Greeting> getAll() {
        return repository.values();
    }

    public Greeting getOne(String lang) {
        if (!repository.containsKey(lang)) {
            throw new ResourceNotFoundException("Greeting for '%s' does not exist".formatted(lang));
        }
        return repository.get(lang);
    }

    public Greeting create(Greeting greeting) {
        repository.put(greeting.lang(), greeting);
        return greeting;
    }

}
