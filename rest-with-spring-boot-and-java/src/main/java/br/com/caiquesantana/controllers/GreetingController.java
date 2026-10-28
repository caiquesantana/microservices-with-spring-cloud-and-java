package br.com.caiquesantana.controllers;

import br.com.caiquesantana.model.Greeting;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //http:localhost:8080/greeting?name=Caique
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Word")
                    String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}
