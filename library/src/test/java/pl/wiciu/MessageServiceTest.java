package pl.wiciu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest("service.message=Tada!")
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test
    public void shouldInitializeWithMessage(){
        assertTrue(!messageService.message().isEmpty());
        assertEquals(messageService.message(),"Tada!");
        //assertEquals(messageService.message(),"Hello");
    }

    @SpringBootApplication
    @Import(MessageConfiguration.class)
    static class TestConfiguration {
    }
}