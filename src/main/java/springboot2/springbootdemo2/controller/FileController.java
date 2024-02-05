package springboot2.springbootdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import springboot2.springbootdemo2.entity.FileInfo;
import springboot2.springbootdemo2.service.FileStorageService;

import java.nio.file.FileStore;
import java.nio.file.Path;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8088")
@RequestMapping("/api/v1")
public class FileController {
    @Autowired
    FileStorageService fileStorageService;
    @PostMapping( "/upload")
    private ResponseEntity<List<FileInfo>> uploadFile(@RequestParam("files")MultipartFile[] files)
    {
        Map<String,Path> listPath=new HashMap<>();
        Arrays.asList(files).forEach(file->
        {
       Path path= fileStorageService.UploadFile(file);
       listPath.put(file.getOriginalFilename(),path);
        });
        List<FileInfo> listFileInfo=new ArrayList<>();
        for (String key:listPath.keySet())
        {
String url= MvcUriComponentsBuilder.fromMethodName(FileController.class,"getFile",listPath.get(key).getFileName().toString()).build().toString();
listFileInfo.add(new FileInfo(key,url));
        }

        return   ResponseEntity.status(HttpStatus.OK).body(listFileInfo);

    }


    @PostMapping("/files/{fileName:}")
    private ResponseEntity<Resource> getFile(@PathVariable String fileName)
    {
        Resource file= fileStorageService.load(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+file.getFilename()+ "\"").body(file);
    }



}
