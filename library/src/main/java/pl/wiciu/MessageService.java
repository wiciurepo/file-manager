package pl.wiciu;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final String message;

    public MessageService() {
        this.message = "test";
    }

    public MessageService(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
