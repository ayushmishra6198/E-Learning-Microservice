package com.service.video.repositories;

import com.service.video.documents.Video;
import com.service.video.dto.VideoDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends MongoRepository<Video, String> {
      List<Video> findByTitleContainingIgnoreCaseOrDescContainingIgnoreCase(String keyword, String desc);
//    List<VideoDto> findByCourseId(String courseId);
      List<Video> findByCourseId(String courseId);
}
