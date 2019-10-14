package newgeekorder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "spring.config.location=classpath:application.properties" })
@SpringBootTest(classes = Hello.class)
//@ActiveProfiles("test")
public class TestRest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    Environment environment;

    @Value( "${server.port}" )
    private String webPort;



    public void getProfileProperties(){
        try {
       System.err.println("found port " +  webPort);
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Test
    public void testRestHello(){
        String port = environment.getProperty("server.port");

        System.err.println("found port " +  webPort);

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:9090" + "/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


}
