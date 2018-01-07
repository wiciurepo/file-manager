package pl.wiciu.commons;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class ApplicationRunnerBean implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        String strArgs = Arrays.stream(arg0.getSourceArgs()).collect(Collectors.joining("|"));
    }
}
