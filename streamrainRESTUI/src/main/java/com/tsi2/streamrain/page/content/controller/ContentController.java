package com.tsi2.streamrain.page.content.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.tsi2.streamrain.datatypes.content.ContentDto;
import com.tsi2.streamrain.datatypes.user.UserDto;
import com.tsi2.streamrain.utils.Utils;

@Controller
public class ContentController {
	
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
			recordFile(contentDto);
		} catch (Exception e) {
			e.printStackTrace();
			return "No se ha podido grabar el fichero";
		}
		
		
		return CONTENT_PREFIX + "createContent";
	}
	
	private void recordFile(ContentDto contentDto) throws Exception {
		CommonsMultipartFile uploaded = contentDto.getPicture();
		String pathFile = "C:\\Users\\juanb\\Documents\\img\\"+uploaded.getOriginalFilename();
		contentDto.setCoverPictureUrl(pathFile);
    	File localFile = new File(pathFile);
    	FileOutputStream os = null;
    	try {
    		os = new FileOutputStream(localFile);
    		os.write(uploaded.getBytes());
    		
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

}
