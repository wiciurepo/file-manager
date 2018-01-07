package pl.wiciu.services.database;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdDataSender implements DataSender{

    @Value("${app.name}")
    private String appName;

    @Override
    public boolean send() {
        System.out.println("Sending data to DB. Application name:" + appName);
        return false;
    }
}
