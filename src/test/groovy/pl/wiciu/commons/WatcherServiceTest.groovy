package pl.wiciu.commons

import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.MockReset
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.test.context.ContextConfiguration
import pl.wiciu.FileManagerApp
import pl.wiciu.services.ServiceForSTub
import pl.wiciu.services.TaskUpdater
import spock.lang.Shared
import spock.lang.Specification
import spock.util.matcher.HamcrestMatchers

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

//@ContextConfiguration(classes = FileManagerApp, loader = SpringBootContextLoader)
@SpringBootTest(classes = FileManagerApp)
@Import(ApplicationRunnerBean)
@MockBean(value = ServiceForSTub, reset = MockReset.AFTER)
class WatcherServiceTest extends Specification {

    private static CountDownLatch latch = new CountDownLatch(1)

    Path testDirAndFile = Paths.get("/home/pawel/source/data/newFileForTest.txt")

    @Autowired
    WatcherService service

    @Autowired
    FileManagerApp managerApp

    @TestConfiguration
    static class Config {
        @Bean
        TaskUpdater taskUpdater() {
            return new TaskUpdater() {
                void update(Path file) {
                    latch.countDown()
                }

            }
        }
    }

    @MockBean
    ServiceForSTub serviceForSTub

   // @MockBean taskUpdater = Mockito.mock(TaskUpdater.class);

    def setupSpec() {


        /*Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                //PUT HERE YOUR CODE
                latch.countDown();
            }
        }).when(taskUpdater).update(_)*/
    }

    def "should scan and infor when new file pops up"() {

        given:
        serviceForSTub.execute() >> {System.out.println("mmmmssss")}
        //taskUpdater.update(_) >> { latch.countDown() }
        managerApp.main()
        TimeUnit.MILLISECONDS.sleep(100)
        //service.scanForFiles()
        Files.delete(testDirAndFile)
        Files.createFile(testDirAndFile)
        latch.await()

        // service.properties;
        when:
        1==1

        then:
        1==1




    }
}
