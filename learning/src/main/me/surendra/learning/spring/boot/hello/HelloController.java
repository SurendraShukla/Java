package me.surendra.learning.spring.boot.hello;

import me.surendra.learning.spring.boot.hello.model.ModelRequest;
import me.surendra.learning.spring.boot.hello.model.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class HelloController {

    private ProcessHandler processHandler;

    @Autowired
    public HelloController(final ProcessHandler processHandler) {
        this.processHandler = processHandler;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
//        return "Greetings from Spring Boot! [" + processHandler.displayProcessCount() + "]";
    }

    @GetMapping(
        value = "test/{campaignId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String test(@PathVariable final long campaignId, @RequestParam final List<String> fields) {
        System.out.println(campaignId);
        System.out.println(fields);
        return fields.toString();
    }

    @PostMapping(
        value = "/model-testing",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ModelResponse dummyName(@RequestBody final ModelRequest modelRequest) {
        System.out.println(modelRequest);
        return ModelResponse.ok();
    }
    
}
