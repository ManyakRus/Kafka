/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.kafka;

import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.kafka.controllers.KafkaController;
import sanek.kafka.model.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {
    
    @Autowired
    KafkaController kafkaController;
    
    @Value(value = "${kafka.topicName}")
    private String topicName;

    @Test
    public void send() {
        String mes = "Hello " + LocalDateTime.now();
        kafkaController.sendMessage(topicName, mes);
    }
    
    
    @Test
    public void sendGreeting() {
        Greeting greeting = new Greeting();
        greeting.setName("greeting1");
        greeting.setMsg("msg1");
        
        String mes = "Hello " + LocalDateTime.now();
        kafkaController.sendGreetings("greeting", greeting);
    }    
}