package com.service.course.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileServiceImpl implements FileService{

    @Override
    public boolean deleteCourseBannerIfExists(String path) {


        Path path1 = Paths.get(path);
        if(Files.exists(path1)){
            try {
                Files.delete(path1);
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    @Override
    public String save(MultipartFile file, String outputPath, String filename) throws IOException {


        // /files/abc.png

        // logic
        Path path = Paths.get(outputPath);
        //create output folder if not exists
        Files.createDirectories(path);

        //video/audio/image processing........

        //ffmpeg
        //code insert karna apne app: process

        //path ko join
        Path filePath = Paths.get(path.toString(), file.getOriginalFilename());
        System.out.println(filePath);
        // file writes
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }
}
