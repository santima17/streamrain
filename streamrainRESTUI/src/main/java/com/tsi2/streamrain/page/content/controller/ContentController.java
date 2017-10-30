package com.tsi2.streamrain.page.content.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.tsi2.streamrain.datatypes.content.ContentDto;

@Controller
public class ContentController {
	
	@Value("${location.file.path}")
	private String location; 
	
	private static final String CONTENT_PREFIX = "/generator/content/";
	
	@RequestMapping(value = "/{tenant}/portal/createContent", method = RequestMethod.GET)
	public String showCreateContent () {		
		return CONTENT_PREFIX + "createContent";
	}
	
	@RequestMapping(value = "/{tenant}/portal/createContentProcess", method = RequestMethod.POST)
    public String createContent(@Valid ContentDto contentDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return CONTENT_PREFIX + "createContent";
		}
		try {
			String pictureName = recordFile(contentDto.getPicture());
			contentDto.setCoverPictureUrl(pictureName);
			String videoName = recordFile(contentDto.getVideo());
			contentDto.setStorageUrl(videoName);
		} catch (Exception e) {
			e.printStackTrace();
			return "No se ha podido grabar el fichero";
		}
		
		
		return CONTENT_PREFIX + "createContent";
	}
	
	private String recordFile(MultipartFile uploaded) throws Exception {
		//Resource resource = new ClassPathResource("/application.properties");
		//Properties props = PropertiesLoaderUtils.loadProperties(resource);
		//String pathLocationFile = props.getProperty("location.file.path");
		
		String pathFile = location+uploaded.getOriginalFilename();
    	File localFile = new File(pathFile);
    	FileOutputStream os = null;
    	try {
    		os = new FileOutputStream(localFile);
    		os.write(uploaded.getBytes());
    		return uploaded.getOriginalFilename();
    	} finally {
    		if (os != null) {
    			try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
	}
	
	@ModelAttribute("contentDto")
	public ContentDto populateForm() {
	     return new ContentDto();
	}

}
