package com.service.video.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VideoDto
{
    private String id;
    private String title;
    private String desc;
    private String filePath;
    private String contentType;
    private  String courseId;
    private  CourseDto course;
}