package newgeekorder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Hello {
    @Value( "${server.port}" )
    private  String webPort;

    static{
        System.err.println("------- application starting .." );

    }

    @PostConstruct
    public void printProps(){
        System.err.println("------- after starting .." + webPort);

    }


    public static void main(String[] args) {
        System.err.println("------- application starting ..");
        SpringApplication.run(Hello.class, args);
    }
}
