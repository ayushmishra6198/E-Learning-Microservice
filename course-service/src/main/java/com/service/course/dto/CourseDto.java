package com.service.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {


    private String id;

    private String title;

    private String shortDesc;

    //    @JsonIgnore
    @JsonProperty("long_description")
    private String longDesc;

    private double price;

    private boolean live = false;

    private double discount;

    private Date createdDate;

    // add your fields

    private String banner;

    //private  String categoryId;
    private String categoryId;

    private CategoryDto categoryDto;

    private List<VideoDto> videos;
    // private List<CategoryDto> categoryList = new ArrayList<>();

    public String getBannerUrl() {

        return  "http://localhost:9092/api/v1/courses/" + id + "/banners";

    }

}
