package com.tsi2.streamrain.page.content.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.tsi2.streamrain.datatypes.content.ContentCastDto;
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
	
	@ModelAttribute("typeList")
	public List<String> populateTypeList() {
		List<String> types = new ArrayList<>();
		types.add("Pel�cula");
		types.add("Serie");
		types.add("Evento Deportivo");
		types.add("Evento Espect�culo");
		return types;
	}
	
	@ModelAttribute("contentDto")
	public ContentDto populateForm() {
		 ContentDto contentDto = new ContentDto();
		 ContentCastDto actor = new ContentCastDto();
		 actor.setFirstName("");
		 actor.setLastName("");
		 actor.setIsActor(true);
		 ContentCastDto actor2 = new ContentCastDto();
		 actor2.setFirstName("");
		 actor2.setLastName("");
		 actor2.setIsActor(true);
		 ContentCastDto actor3 = new ContentCastDto();
		 actor3.setFirstName("");
		 actor3.setLastName("");
		 actor3.setIsActor(true);
		 ContentCastDto actor4 = new ContentCastDto();
		 actor4.setFirstName("");
		 actor4.setLastName("");
		 actor4.setIsActor(true);
		 ContentCastDto actor5 = new ContentCastDto();
		 actor5.setFirstName("");
		 actor5.setLastName("");
		 actor5.setIsActor(true);
		 contentDto.setActors(Arrays.asList(actor,actor2, actor3, actor4, actor5));
		 
		 ContentCastDto director = new ContentCastDto();
		 director.setFirstName("");
		 director.setLastName("");
		 director.setIsDirector(true);
		 ContentCastDto director2 = new ContentCastDto();
		 director2.setFirstName("");
		 director2.setLastName("");
		 director2.setIsDirector(true);
		 ContentCastDto director3 = new ContentCastDto();
		 director3.setFirstName("");
		 director3.setLastName("");
		 director3.setIsDirector(true);
		 contentDto.setDirectors(Arrays.asList(director,director2, director3));
		 
	     return contentDto;
	}

}
