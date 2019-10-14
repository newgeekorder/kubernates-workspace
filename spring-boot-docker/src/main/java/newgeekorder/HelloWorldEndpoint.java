package newgeekorder;



import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@RestController
public class HelloWorldEndpoint {

   @RequestMapping("/hello")
    @Produces("application/json")
    public String test() {
        return "hello world";
    }
}