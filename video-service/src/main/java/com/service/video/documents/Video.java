package com.service.video.documents;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Video {

    @Id
    private String id;

    private  String title;

    private  String desc;

    private  String filePath;

    private  String contentType;

    private  String courseId;
    // add your choice of field
//
//    @ManyToOne
//    private  Course course;

}