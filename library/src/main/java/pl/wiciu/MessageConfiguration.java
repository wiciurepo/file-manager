package pl.wiciu;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MessageProperties.class)
public class MessageConfiguration {

    @Bean
    MessageService messageService(MessageProperties messageProperties) {
        return new MessageService(messageProperties.getMessage());
    }
}
