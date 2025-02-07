package cz.tomkre.edu.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("ping")
    public Map<String, Object> ping() {
        return Map.of("app", "eds-app");
    }

}
