package com.training.project102.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.project102.model.Names;
import com.training.project102.service.NamesService;



@RestController
@Component
public class WelcomeController {
	
	@Autowired
    private NamesService nameService;
	
	
	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
	@GetMapping(path="/hello/{var}")
	public String hello(@RequestHeader HttpHeaders headers,HttpServletRequest request) {
		logger.error(headers.get("accept-language"));
		logger.error(request.getRequestURI());
		if (headers.containsKey("accept-language")  && headers.get("accept-language").toString().trim().toLowerCase().contains("application/xml")) {
			return "<value>Hello " + request.getRequestURI().toString().substring(7) + "</value>";	
			
		}else if (headers.containsKey("accept-language")  && headers.get("accept-language").toString().trim().toLowerCase().contains("application/json")){
			return "{ \"value\" : \"Hello World\" }";
			
		}else {
			
			return "Please Pass  Header";
		}
	}
	
    @RequestMapping(value = "/hello/{var}", method = RequestMethod.PUT)
	public String helloput(@RequestBody Names names,@RequestHeader HttpHeaders headers,HttpServletRequest request) {
		logger.error(headers.get("accept-language"));
		logger.error(request.getRequestURI());
		String retVal1 = null;
		
		if (headers.containsKey("accept-language")  && headers.get("accept-language").toString().trim().toLowerCase().contains("application/xml")) {
			names.setName(request.getRequestURI().toString().substring(7));
			try {
				names =  nameService.createNames(names);
				retVal1 = "<id>" + names.getId() + "</id>" + "    "+ "<name>"+ names.getName() + "</name>";

			}catch(Exception e) {
				
				logger.error(e.getMessage());
			}
			
			return retVal1;
			
		}else if (headers.containsKey("accept-language")  && headers.get("accept-language").toString().trim().toLowerCase().contains("application/json")){
			names.setName(request.getRequestURI().toString().substring(7));
			try {
				names =  nameService.createNames(names);
				retVal1 = "{ \"id\" :" + "\""+names.getId() + "\""+ "}" + "    " +  "{ \"name\" :"  + "\""+ names.getName() + "\""+ "}";

			}catch(Exception e) {
				logger.error(e.getMessage());
			}

			return retVal1;
			
		}else {
			
			return "Please enter a valid accept-language Header";
		}
	}
	
	@GetMapping(path="/coal-mine")
	public String coalMine() {
		return "Tweet";
	}
}