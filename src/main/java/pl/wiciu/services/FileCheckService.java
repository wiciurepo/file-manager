package pl.wiciu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.wiciu.commons.FileUtils;

import java.io.IOException;

@Component
public class FileCheckService {

    @Value("${input.file.dir}")
    String inputDir;

    @Autowired
    FileUtils fileUtils;

    public void listInputDir() throws IOException {

        System.out.println(fileUtils.listFilesInPath(inputDir));

    }



}
