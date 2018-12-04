package com.demo.txt.configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.demo.txt.controller.WebController;
import com.demo.txt.utility.FileUtility;

@Configuration
@EnableScheduling
public class ScheduleConfig {
	
	private Logger logger = Logger.getLogger(WebController.class.getName());

	@Autowired
	private WebController webController;

	@Scheduled(fixedDelay = 1000*40)
	public void scheduleFixedDelayTask() throws IOException {

		File file = FileUtility.lastFileModified("F:\\kartavya\\shared\\text");
		if(file!=null){
			String content = new String(Files.readAllBytes(Paths.get(file.getPath())));

			webController.saveFileData(content, file.getName());
			// renaming the file and moving it to a new location 
			if(file.renameTo 
					(new File("F:\\kartavya\\shared\\text\\archive\\"+file.getName()))) 
			{ 
				//if file copied successfully then delete the original file 
				file.delete(); 
				logger.info("File moved successfully"); 
			} 
			else
			{ 
				logger.info("Failed to move the file"); 
			} 
		} else {
			logger.info("No files available"); 
		}

	}
}
