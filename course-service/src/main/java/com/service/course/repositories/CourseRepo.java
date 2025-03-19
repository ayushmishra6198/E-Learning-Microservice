package com.service.course.repositories;

import com.service.course.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course,String> {

    Optional<Course> findByTitle(String title);

    Page<Course> findByLive(boolean live, Pageable pageable);


    List<Course> findByTitleContainingIgnoreCaseOrShortDescContainingIgnoreCase(String keyword, String keyword1);

}
