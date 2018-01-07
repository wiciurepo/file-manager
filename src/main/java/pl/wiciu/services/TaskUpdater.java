package pl.wiciu.services;

import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class TaskUpdater {


    public void update(Path file) {
        System.out.println("Updated" + file);

    }

}
