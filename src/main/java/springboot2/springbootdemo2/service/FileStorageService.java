package springboot2.springbootdemo2.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileStorageService {

    void init();
    Path UploadFile(MultipartFile multipartFile);
    Resource load(String filename);
}
