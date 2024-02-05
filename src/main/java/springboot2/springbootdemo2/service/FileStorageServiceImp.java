package springboot2.springbootdemo2.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileStorageServiceImp implements FileStorageService
{

    private  final Path PATH_ROOT= Paths.get("upload");

//    @Value("${file.upload-dir}")
//    private String uploadDir;
    @Override
    public void init() {
        try {
            Files.createDirectories(PATH_ROOT);

        }
    catch (IOException e) {
        System.out.println("Could not inital folder uploadd");

            throw new RuntimeException("Could not inital file folder");

        }
    }

    @Override
    public Path UploadFile(MultipartFile multipartFile) {
try
{
Files.copy(multipartFile.getInputStream(),PATH_ROOT.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())));
return  PATH_ROOT.resolve(multipartFile.getOriginalFilename());
}
catch (IOException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public Resource load(String filename) {

        try {
            Path file=PATH_ROOT.resolve(filename);
            Resource resource= null;
            resource = new UrlResource(file.toUri());
            if(resource.exists()||resource.isReadable())
            {
                return resource;
            }
            else
            {
                throw new RuntimeException("Could not read file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
