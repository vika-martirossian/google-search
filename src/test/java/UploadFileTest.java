import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UploadFilePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

public class UploadFileTest extends BaseTest {
    private UploadFilePage uploadFilePage;

    @BeforeMethod
    public void setUp() {
        uploadFilePage = new UploadFilePage();
    }

    @Test
    public void uploadFile() throws IOException {
        Path filePath = Files.createTempFile("testFile", ".txt");
        File file = filePath.toFile();
        String path = file.getAbsolutePath();
        uploadFilePage.typePath(path);
        uploadFilePage.submit();

        assertTrue(uploadFilePage.getUploadedFiles().contains(file.getName()),
                "File was not uploaded!");
    }
}
