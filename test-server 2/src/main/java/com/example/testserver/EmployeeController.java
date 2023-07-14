package com.example.testserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * Take an input(name) from the FE and return "Hello " + person name
     */

    /**
     * Base url : Domain name / IP + Port
     * Steps to write an API
     * Define the HTTP method
     * Define endpoint / API Path
     * Define how to take input if reqd [Optional]
     * Define teh response type
     */

    // /hello?name=Nitisha

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String n) {

        return "Hello " + n + "!!";

    }

    @GetMapping("/logtest")
    public String helloWorld(){

        logger.error("This is an error log");
        logger.warn("This is a warn log");
        logger.info("This is a info log");
        logger.debug("This is a debug log");
        logger.trace("This is a trace log");

        return "Hello World";

    }
}
