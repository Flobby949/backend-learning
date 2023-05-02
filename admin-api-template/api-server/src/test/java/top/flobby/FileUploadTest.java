package top.flobby;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FileUploadTest {
    // @Autowired
    // private StorageService storageService;
    //
    // @Test
    // void uploadTest() throws IOException {
    //     File file = new File("C:\\Users\\Flobby\\Desktop\\MY\\avatar\\1.jpg");
    //     byte[] bytes = IoUtil.readBytes(Files.newInputStream(file.toPath()));
    //     String path = storageService.getPath(file.getName());
    //     String url = storageService.upload(bytes, path);
    //     log.info(url);
    // }
}