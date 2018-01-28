package pl.wiciu.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource(value = "classpath:conf/externalpath.properties"),
        @PropertySource(value = "file:../conf/external.properties", ignoreResourceNotFound = true)
})

public class DisplayText {

    @Value("${display.text}")
    String displayText;

    @Value("${external.text}")
    String externalText;

    @Value("${additional.external.text}")
    String additionalExternalText;

    @Value("${external.path.text}")
    String externalPathText;

    public void display() {

        //throw new Error("error - abort execution");

        System.out.println("TADA:" + displayText);
        System.out.println("TADA external:" + externalText);
        System.out.println("TADA additional external:" + additionalExternalText);
        System.out.println("TADA external path:" + externalPathText);

    }

}
