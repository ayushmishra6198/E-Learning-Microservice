package com.service.video;

import com.service.video.documents.Video;
import com.service.video.repositories.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VideoServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Autowired
	private VideoRepo videoRepo;
	@Override
	public void run(String... args) throws Exception {
		Video video = new Video();
		video.setDesc("This is a dummy video");
		video.setTitle("Dummy Video");
		video.setContentType("video/mp4");
		video.setFilePath("./videos/first.mp4");

		Video save = videoRepo.save(video);

		System.out.println("Video saaved with Id :" + save.getId());
	}
}
