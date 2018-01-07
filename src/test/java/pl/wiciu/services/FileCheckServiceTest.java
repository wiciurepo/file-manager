package pl.wiciu.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileCheckServiceTest {


    private FileCheckService checkService;
    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp(){
        context = new AnnotationConfigApplicationContext(ServicesConfiguration.class);
        checkService = context.getBean(FileCheckService.class);
    }

    @After
    public void cleanUp(){
        context.close();
    }

    @Test
    public void shouldListFilesInConfiguredDir() throws IOException {
        //given

        //when
        checkService.listInputDir();

        //then




    }


}