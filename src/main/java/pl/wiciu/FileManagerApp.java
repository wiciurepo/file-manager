package pl.wiciu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;
import pl.wiciu.commons.WatcherService;
import pl.wiciu.config.ConditionalConfig;
import pl.wiciu.config.ConditionalService;
import pl.wiciu.services.database.DataSender;

import java.io.IOException;

@EnableAsync
@SpringBootApplication
public class FileManagerApp {

    public static void main(String[] args) {


        ConfigurableApplicationContext run = SpringApplication.run(FileManagerApp.class, args);



        WatcherService watcherService = run.getBean(WatcherService.class);
        try {
            watcherService.scanForFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }


        JarClassLoader jcl = run.getBean(JarClassLoader.class);
        JclObjectFactory jclObjectFactory = run.getBean(JclObjectFactory.class);

        ConditionalConfig bean = run.getAutowireCapableBeanFactory().createBean(ConditionalConfig.class);
        run.getAutowireCapableBeanFactory().autowireBean(bean);

        run.getBean(ConditionalService.class).run();

        run.getBean(DataSender.class).send();
        //Object messageService = jclObjectFactory.create(jcl, "pl.wiciu.MessageService");

        //Create object of loaded class
        //Object obj = factory.create(jcl,"myapi.impl.MyInterfaceImpl");

        //Obtain interface reference in the current classloader
       // MessageService mi = JclUtils.cast(messageService, MessageService.class);

        //System.out.println(run.getBean(MessageService.class).message());
        //System.out.println(mi.message());




        System.out.println("Not affected by wait");

    }

}
