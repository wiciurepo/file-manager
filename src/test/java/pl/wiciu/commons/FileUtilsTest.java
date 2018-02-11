package pl.wiciu.commons;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class FileUtilsTest {

    private static final String INPUT_DIR = "/home/pawel/source/data";

    @Test
    public void shouldReadFileFromClasspath() throws IOException {
        //given
        FileUtils utils = new FileUtils();
        BlockingDeque<String> deque;

        //when
        InputStream stream = utils.loadFileFromClasspath("/test.txt");


        //then
        assertThat(stream.available()).isGreaterThan(0);
        assertThat(IOUtils.toString(stream, StandardCharsets.UTF_8)).contains("1","2","3","4","5");
    }

    @Test
    public void shouldReadFileLinesFromPath() throws IOException {
        //given
        FileUtils utils = new FileUtils();

        //when
        List<String> lines = utils.loadFileByLineFromPath(INPUT_DIR,"test.new");


        //then
        assertThat(lines.size()).isGreaterThan(0);
        assertThat(lines).contains("a","b","c","d","e");
    }


    @Test
    public void shouldListFilesFromPath() throws IOException {
        //given
        FileUtils utils = new FileUtils();

        //when
        List<Path> files = utils.listFilesInPath(INPUT_DIR);


        //then
        assertThat(files.get(0).toString()).contains("test.new");
    }

}