package pl.wiciu.services;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;
import pl.wiciu.MessageConfiguration;
import pl.wiciu.commons.FileUtils;

@Configuration
@Import(MessageConfiguration.class)
@PropertySource("classpath:application.properties")
public class ServicesConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static FileUtils getFileUtils() {
        return new FileUtils();
    }

    @Bean
    public static FileCheckService getFileCheckService() {
        return new FileCheckService();
    }

    @Bean
    JarClassLoader jarClassLoader() {
        JarClassLoader jarClassLoader = new JarClassLoader();
        jarClassLoader.add("/home/pawel/source/file-manager/library/build/libs");
        return jarClassLoader;
    }


    @Bean
    JclObjectFactory jclObjectFactory() {
        return JclObjectFactory.getInstance();
    }

    @Bean(name = "asyncTaskPoolExecutor")
    public TaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("Async scan thread-");
        executor.initialize();
        return executor;
    }


}
